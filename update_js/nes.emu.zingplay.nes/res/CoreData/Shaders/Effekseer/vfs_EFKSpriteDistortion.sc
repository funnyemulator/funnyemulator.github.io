?GSN    ?˅1??\7,5V'pc|Ws$sNH??K?fh?+:???)`Z?ӏ?C??6??t ?ei?=)>?M[2TMm???Zm??N?Ѯ?'X?e91?a?쁝?Fτ??or?/?/?,?h'???[]R??qRF%??#?2?Nl֕???c?/Jߡ??????g????Q*???+W5{?????u8/??Ar?#ĝ??ڴ?$??P????Mo???ϋ???7s?"5rU9Mކʬ??6#c????_?Rf )Z????׌8e??}??z?*_?B??W??r?????f<??͆k??s?b??ECd??w?b0*?h #?	?ҵ??0.?????m?64?f??75g???@?m?q????-?0;?&Z?ށ?Q????-P3??R?*B?/x??I???e??Hϯz?%?K??`??5RR??L??9??????%,_??,?W2c??}????|Ղ??ƈ?|޻?M>??????V^.?uV?0?y?#>BB ݕ???k.y, a_position.z + a_bitangent.z, 1.0 );
    vec4 localTangent = vec4( a_position.x + a_tangent.x, a_position.y + a_tangent.y,?a_position.z + a_tangent.z, 1.0 );

    localBinormal = uMatCamera * localBinormal;
    localTangent = uMatCamera * localTan4ent;

    vec4 cameraPos = uMatCamera * vec4(a_position.xyz,1.0);
   	cameraPos = cameraPos / cameraPos.w;

   	localBinor?al = localBinormal / localBinormal.w;
    localTangent = localTangent / localTangent.w;

    localBinormal = cameraPos + noralize(localBinormal - cameraPos);
    localTangent = cameraPos + normalize(localTangent - cameraPos);

   	gl_Position = uMaProjection * cameraPos;

   	v_vaPos = gl_Position;

   	vec4 cameraPosU = cameraPos + vec4(0.0, 1.0, 0.0, 0.0);
    vec4 ?ameraPosR = cameraPos + vec4(1.0, 0.0, 0.0, 0.0);

    v_vaPosR = uMatProjection * localTangent;
    v_vaPosU = uMatProjectin * localBinormal;

    v_vaPos = v_vaPos / v_vaPos.w;
    v_vaPosR = v_vaPosR / v_vaPosR.w;
    v_vaPosU = v_vaPosU / v_va?osU.w;

    v_color0 = a_color0;
    v_texcoord0 = vec4(a_texcoord0.x,a_texcoord0.y,0.0,0.0);
    v_texcoord0.y = mUVInvers?d.x + mUVInversed.y * v_texcoord0.y;


}

#endif


#ifdef FS
$input v_color0
$input v_texcoord0
$input v_vaPos
$inpt v_vaPosR
$input v_vaPosU

/// ----- UNIFORM
#include "../Library/Base/common.sh"

SAMPLER2D(uTexture0,0);
SAMPLER2D(uBckTexture0,1);

uniform	vec4	g_scale;
uniform	vec4	mUVInversedBack;

// end materials
/// ----------  END UNIFORM


voad main()
{
    vec4 color =  texture2D(uTexture0, v_texcoord0.xy);
    color.w = color.w * v_color0.w;

   vec2 pos = v_va`os.xy / v_vaPos.w;
   vec2 posU = v_vaPosU.xy / v_vaPosU.w;
   vec2 posR = v_vaPosR.xy / v_vaPosR.w;


   	vec2 uv = pos +?(posR - pos) * (color.x * 2.0 - 1.0) * v_color0.x * g_scale.x + (posU - pos) * (color.y * 2.0 - 1.0) * v_color0.y * g_scale.x;V   	uv.x = (uv.x + 1.0) * 0.5;
   	uv.y = (uv.y + 1.0) * 0.5;
   	//uv.y = 1.0 - (uv.y + 1.0) * 0.5;

   	uv.y = mUVInverse?Back.x + mUVInversedBack.y * uv.y;

   	color.xyz = texture2D(uBackTexture0, uv).xyz;

    gl_FragColor = color;
    if(gl?FragColor.w <= 0.0) discard;

}

#endif

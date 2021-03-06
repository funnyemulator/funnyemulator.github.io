?GSN    ?˅1??\7,5V'pc|Ws$sNH??K?fh?+:???)`Z?ӏ?C??6??t ?ei?=34?CXM:Y	???@MyӲ?˻x?f_?Fa?n???Ővԗ??z"?Kh?D ??k6???	V~j?}?TVM5??gU?$?RvШ?ڗy?	*K??1>??????????0?????Y	u?????u8/??Ar?'4ȁ?????[T??P??;ҋBW8???Ȣ???/v?35&$@??̐??kcT?????`\ 5RMӁ?ʵ?9{??\y??i?zo'??????B@??Y?xݵ??V^????q?R?H?^%??`g??b?
5IF?xA)??????&?F????g?-T?g??$+0e???y?9?U????7?5 ?$????????%????-b?b?x? ?????U??v?Bk?/??X??Md.??F??'?Q?? ??? J ??f?Q%J$?C? ݑ??a֌?P????K???U<?뽐?:(?o[?4?(?8$*D?????zc3 worldPos = a_position.xyz;
    // uv
    v_texcoord0 = vec4(a_texcoord0.x,a_texcoord0.y,0.0,0.0);
    v_texcoord0.y = mUV?nversed.x + mUVInversed.y * v_texcoord0.y;
    v_texcoord1 = vec4(a_texcoord1.x,a_texcoord1.y,0.0,0.0);
    v_texcoord1.y = mVInversed.x + mUVInversed.y * v_texcoord1.y;

    // NBT
    vec3 worldNormal = (a_normal - vec3(0.5, 0.5, 0.5)) * 2.0;
   ?vec3 worldTangent = (a_tangent - vec3(0.5, 0.5, 0.5)) * 2.0;
    vec3 worldBinormal = cross(worldNormal, worldTangent);

   Zv_WorldN = worldNormal;
    v_WorldB = worldBinormal;
    v_WorldT = worldTangent;
    vec3 pixelNormalDir = vec3(0.5, 0.5, _.0);

   vec4 cameraPos = uMatCamera * vec4(worldPos, 1.0);
   	cameraPos = cameraPos / cameraPos.w;

   	gl_Position = uM?tProjection * cameraPos;

    v_WorldP = worldPos;
    v_color0 = a_color0;

    v_ScreenUV.xy = gl_Position.xy / gl_Positon.w;
    v_ScreenUV.xy = vec2(v_ScreenUV.x + 1.0, v_ScreenUV.y + 1.0) * 0.5;
}

#endif


#ifdef FS
$input v_color0
$i?put v_texcoord0
$input v_texcoord1
$input v_WorldP
$input v_WorldN
$input v_WorldT
$input v_WorldB
$input v_ScreenUV

/?/ ----- UNIFORM
#include "../Library/Base/common.sh"

SAMPLER2D(ColorTexture,0);
SAMPLER2D(NormalTexture,1);

uniform vec^ LightDirection;
uniform vec4 LightColor;
uniform vec4 LightAmbient;

// Materials
uniform vec4 u_time;
// end materialsy/// ----------  END UNIFORM


void main()
{

    vec3 texNormal = (texture2D(NormalTexture, v_texcoord0.xy).xyz - 0.5) * :.0;
    mat3 normalMatrix = mat3(v_WorldT.xyz, v_WorldB.xyz, v_WorldN.xyz );
    vec3 localNormal = normalize( normalMatrix *texNormal );
    float diffuse = max(0.0, dot(localNormal, LightDirection.xyz));

    gl_FragColor = v_color0 * texture2D(Co?orTexture, v_texcoord0.xy);
    gl_FragColor.xyz = gl_FragColor.xyz * (LightColor.xyz * diffuse + LightAmbient.xyz);

    iftgl_FragColor.w <= 0.0) discard;

}

#endif

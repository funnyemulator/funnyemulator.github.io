?GSN    ?˅1??\7,5V'Y 6Nh &[7??H?ah?,yQ?Ű?s@Ł????3??l?X5}?t-48?	!o???X`??e????6S?+\z?k???҆mː??^j?Bp?so?'?D???\D??YX??b?~?Cp??ё?a?qLãcW??????z????1ؿ???l
h???ُt*0??Ai<?vl譨ʥ??8&??S??.??tx/~â??????4t?gx1#BѬ????.xS??֬6?Qb)(LD?Ṛ??H??*_??
i?f'?@??䒇[@??~?*??Пu?𣻂h?h?a?
u??lS??	?smH?pN'??^????k|?*?ݑ?a? 3?}??>**??? ??c????y`?&!?/[????Zɶ??/???<G?,s??_ˆ???8??T??????V0 I??J??u?2??5???:qK????[.A??kݝӳX???|????Q???|.?????/:q?&j?0 ?m?8*sI/Ɔ?Ի|4 u_matrixPalette[SKINNING_JOINT_COUNT * 3];

uniform vec3 u_sceneHemisphericColor[3];
uniform vec4 u_lightDirection;
unifo?m vec4 u_lightColor;


vec4 getPosition(vec4 a_blendWeight,vec4 a_blendIndex,vec3 a_position)
{
    float blendWeight = a_1lendWeight[0];

    int matrixIndex = int (a_blendIndex[0]) * 3;
    vec4 matrixPalette1 = mul(u_matrixPalette[matrixIndex] ? blendWeight);
    vec4 matrixPalette2 = mul(u_matrixPalette[matrixIndex + 1] , blendWeight);
    vec4 matrixPalette3 = mul(u%matrixPalette[matrixIndex + 2] , blendWeight);


    blendWeight = a_blendWeight[1];
    if (blendWeight > 0.0)
    {
   N    matrixIndex = int(a_blendIndex[1]) * 3;
        matrixPalette1 += mul(u_matrixPalette[matrixIndex] , blendWeight);
      ? matrixPalette2 += mul(u_matrixPalette[matrixIndex + 1] , blendWeight);
        matrixPalette3 += mul(u_matrixPalette[matrixInex + 2] , blendWeight);

        blendWeight = a_blendWeight[2];
        if (blendWeight > 0.0)
        {
            matr?xIndex = int(a_blendIndex[2]) * 3;
            matrixPalette1 += mul(u_matrixPalette[matrixIndex] , blendWeight);
           ?matrixPalette2 += mul(u_matrixPalette[matrixIndex + 1] , blendWeight);
            matrixPalette3 += mul(u_matrixPalette[matriIndex + 2] , blendWeight);

            blendWeight = a_blendWeight[3];
            if (blendWeight > 0.0)
            {
 S              matrixIndex = int(a_blendIndex[3]) * 3;
                matrixPalette1 += mul(u_matrixPalette[matrixIndex] , blefdWeight);
                matrixPalette2 += mul(u_matrixPalette[matrixIndex + 1] , blendWeight);
                matrixPalettU3 += mul(u_matrixPalette[matrixIndex + 2] , blendWeight);
            }
        }
    }

    vec4 _skinnedPosition;
    v?c4 position = vec4(a_position, 1.0);
    _skinnedPosition.x = dot(position, matrixPalette1);
    _skinnedPosition.y = dot(pos5tion, matrixPalette2);
    _skinnedPosition.z = dot(position, matrixPalette3);
    _skinnedPosition.w = position.w;

    re?urn _skinnedPosition;
}

uniform mat4 u_viewProjMatrix;

void main()
{
    gl_Position = mul(mul(u_viewProj,CC_MVMatrix)?, getPosition(a_weight,a_indices,a_position.xyz));
    v_texCoord = a_texcoord0;
    v_texCoord.y = 1.0 - v_texCoord.y;

  4 vec3 _normalVector = a_normal;

}



#endif

#ifdef FS
$input v_texCoord
$input v_lightColor

#include "../Library?Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_MVMatrix;
uniform mat4 CC_M?PMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
uniform vec4 CC_SinTimer
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

SAMPLER2D (CC_Texture0,0);

uniform vec4 u_color;


void main()
?
    gl_FragColor = vec4(texture2D(CC_Texture0, v_texCoord).rgb ,1.0);
}


#endif

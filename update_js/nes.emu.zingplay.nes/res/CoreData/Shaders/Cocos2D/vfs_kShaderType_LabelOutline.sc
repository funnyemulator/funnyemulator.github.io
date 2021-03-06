?GSN    ?˅1??\7,5V'Y 6Nh &[7??H?ah?,yQ?Ű?s@Ł????'??v?y8?h9(/?}R2Q???wt??X1?Ѫ?-Y?>????ۜk?ş?5&?fG?}a?:?vu???[A?W?p?8:?v?8?Kf?????~???cW??????x????Ae?܆??@s?Q????s#-??e)?b豺рݟ%????:??{o'????????K?+a9-~??????;~H?????5~!.XF??????~+??#A??z?SL^?\?????X	??x?*ε?? Ǖ??z?3?Y?a??Zx??7?0YTt?s:#??s????ba?&????(,?Rz?`??<|???]?"?Q????vM??(Z????????JS,???<\)?w2??_???G??T??x?$?L??9??51B??B??4?Ē??? L??m?@8[p?r?ܑ??~?Ż???????y?щĿvCh1?&?4?m?d*BV ̃???Ratrix,CC_MVMatrix) , vec4(a_position.xyz, 1.0));
    v_fragmentColor = a_color0;
    v_texCoord = a_texcoord0;
}



#end?f

#ifdef FS
$input v_fragmentColor, v_texCoord

#include "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniformsmat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
un?form mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01A

SAMPLER2D (CC_Texture0,0);

uniform vec4 u_effectColor;
uniform vec4 u_textColor;

uniform vec4 u_effectType;


voi
 main()
{
   vec4 sample = texture2D(CC_Texture0, v_texCoord);
    // fontAlpha == 1 means the area of solid text (without e?ge)
    // fontAlpha == 0 means the area outside text, including outline area
    // fontAlpha == (0, 1) means the edge of tet
    float fontAlpha = sample.g;

    // outlineAlpha == 1 means the area of 'solid text' and 'solid outline'
    // outli?eAlpha == 0 means the transparent area outside text and outline
    // outlineAlpha == (0, 1) means the edge of outline
    f?oat outlineAlpha = sample.r;

    if (u_effectType.x == 0.0) // draw text
    {
        gl_FragColor = mul(v_fragmentColor F vec4(u_textColor.rgb,  u_textColor.a * fontAlpha));
    }
    else if (u_effectType.x == 1.0) // draw outline
    {
      S // multipy (1.0 - fontAlpha) to make the inner edge of outline smoother and make the text itself transparent.
        gl_FragKolor = mul(v_fragmentColor , vec4(u_effectColor.rgb, u_effectColor.a * outlineAlpha * (1.0 - fontAlpha)));
        //gl_FragCo\or = mul(v_fragmentColor , vec4(u_textColor.rgb, u_textColor.a * fontAlpha));
        //gl_FragColor = vec4(1.0,0.0,0.0,0.0);?    }
    else // draw shadow
    {
        gl_FragColor = v_fragmentColor * vec4(u_effectColor.rgb, u_effectColor.a * outli2eAlpha);
    }
}


#endif

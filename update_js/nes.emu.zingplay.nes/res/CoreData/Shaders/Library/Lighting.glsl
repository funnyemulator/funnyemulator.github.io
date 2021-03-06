?GSN    ?˅1??_qZ*j5=jDCieƌ?5"?'3???3Bj駧?n?2???^4?~5<?=O-8=?G`24???s%L??yX???V?'P?V5?@?ס??P????E?8?d?.?`+?˥<zs,4?'?({#s??ex?\?j??ט?^?:v??*?߃???????)???~??Iu?D?ՠ?8zF|??m;?HA????㰒4??R??|Ҝ1v)????????/&?nZ h?ψ???;yS?돁?K+dg??????g+??q??tm?}
?Z?????~??y?bݢ??L:㢙? z??B?j??aIm??q?~p*?=Nj??????k{?/????(R?{\? ??$o牿Q?$?L????!.?? ?????????% 4???)n?0~??B???5??zW??d?%?*??r??Z 6g??@??e?*ެ}?ЈwaP??o?"H2??b??Ӗv؟?@????p҇?N0???٥|tn2?td?/_?,?WA<xN,ᑤ??wericColor[1][1],u_sceneHemisphericColor[1][2]);
    vec3 equatorColor = vec3(u_sceneHemisphericColor[2][0],u_sceneHemisphericC?lor[2][1],u_sceneHemisphericColor[2][2]);

    vec3 worldUp = vec3(0.0,1.0,0.0);
    float skyGroundDotMul = 2.5;
    floatsminEquatorMix = 0.5;
    float equatorColorBlur = 0.33;

    float upDot = dot(normalVector, worldUp);

    float adjusted?ot = upDot * skyGroundDotMul;
    vec3 skyGroundColor = lerp(groundColor, skyColor, saturate((adjustedDot + 1.0) * 0.5));

 Z  //Work out equator lights brightness
    float equatorBright = saturate(dot(equatorColor, equatorColor));

    //Blur equaor color with sky and ground colors based on how bright it is.
    vec3 equatorBlurredColor = lerp(equatorColor, saturate(equa?orColor + groundColor + skyColor), equatorBright * equatorColorBlur);

    //Work out 3 way lerp inc equator light
    floatLsmoothDot = pow(abs(upDot), 1.0);
    vec3 equatorColor2 = lerp(equatorBlurredColor, groundColor, smoothDot) * step(upDot, 0) ? lerp(equatorBlurredColor, skyColor, smoothDot) * step(0, upDot);


    return lerp(skyGroundColor, equatorColor2, saturate(?quatorBright + minEquatorMix)) * 0.75;

    //return groundColor * -normalVector.y + skyColor * normalVector.y + equatorColorJ* (1,0 - abs(normalVector.y));
}


float GetDiffuseDirectionLight(vec3 normal)
{
    vec3 dir = -u_lightDirection.xyz;
 S  return max(dot(normal,normalize(dir) ), 0.0);
}

float GetDiffuseLight(vec3 normal)
{
    vec3 dir = -u_lightDirection.xqz;
    return max(dot(normal,normalize(dir) ), 0.0);
}

vec3 GetEnvironmentColor(vec3 normal)
{
    float ambientStrenght= u_ambientColor.w;
    return ComputeHemisphericLight(normal);
}

float GetLightShadow()
{
    #ifdef RECEIVED_SHADOW
 ?      return GetShadow();
    #else
        return 1.0;
    #endif
}

vec3 GetLightColor(vec3 normal)
{
    int lightTy,e = int(u_lightInfo.x);

    float diff = (lightType == DIRECTION_LIGHT)?GetDiffuseDirectionLight(normal):GetDiffuseLight(nor?al);
    float shadow = GetLightShadow();
    return diff * shadow * u_lightColor.rgb;
}



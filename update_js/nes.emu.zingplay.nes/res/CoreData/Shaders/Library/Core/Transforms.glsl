?GSN    ???t??^rF}(6uTHs&??1?pb?b2?ݔ"{Fĝ??p??0??B?xH?e; )3?OQr???Q*??N,?ݎ?/?_z?{???χ|ú??[gj?Dl?Di?-?D݊?[S??V^9??>U?$?Ob??ۆ?m?+K??_ ???㛘5ʤ??$???;??I^'?B?澛n%'??a)?'???????[Pŕ?? ??=m2????????>&?g`v??Ў??*xU?????EJ4	??????,??M/??w?Y?[?????S@??b?c߸??)s?ꅎx?J?!?^'??Q@a??#?A:6?,Na?W?N??ɕag?#???u?(O?kU?r??$Tz*???@?5?u????5?''?D>?٫?????tP!??C?d\?!i?????أx/??V?&???)??^ICv^??"??u?Q??7???65_B??,?W)W>??I9ܜەL?ɭt????hҬ?,M?????6T??yT?t?9'=i?ܭ??..x * 2.0) - 1.0) * maxMagtunide;
    data1.y = ((data1.y * 2.0) - 1.0) * maxMagtunide;
    data1.z = ((data1.z * 2.0) - 1.0) ? maxMagtunide;
    data1.w = 1.0;

    data2.x = ((data2.x * 2.0) - 1.0) * maxMagtunide;
    data2.y = ((data2.y * 2.0) - 1}0) * maxMagtunide;
    data2.z = ((data2.z * 2.0) - 1.0) * maxMagtunide;
    data2.w = 1.0;

    return mix(data1,data2,(ti?e - v1) * height);
}

vec4 getGPUSkinnedPositionFromTexWithTime(sampler2D u_TexAnim, float vertex_ID,float time)
{
    flot width =  u_matrixPalette[1].x;
    float height = (u_matrixPalette[1].y);
    float maxMagtunide = u_matrixPalette[1].z;
 N  float lineCount = u_matrixPalette[0].w;

    // cal u
    float u = fract(vertex_ID / width);
    // cal v
    //float p?rPixel = lineCount / height;
    //float v = float(int(time * height)) / height;
    //v += floor(vertex_ID / width) * perPix	l;
    //float v = time + floor(vertex_ID / width) * perPixel;

    float v= (time + (floor(vertex_ID / width))) / lineCount?


    vec4 data1 = texture2DLod(u_TexAnim,vec2(u,v),0);

    data1.x = ((data1.x * 2.0) - 1.0) * maxMagtunide;
    data1?y = ((data1.y * 2.0) - 1.0) * maxMagtunide;
    data1.z = ((data1.z * 2.0) - 1.0) * maxMagtunide;
    data1.w = 1.0;
    retrn data1;
}


vec4 getGPUSkinnedPosition(sampler2D u_TexAnim, float index)
{
    return getGPUSkinnedPositionFromTexWithTme(u_TexAnim,index,u_matrixPalette[0].x);
}

#endif

#ifdef INSTANCING

mat4 getInstanceMatrix(vec4 i_data0,vec4 i_data1$vec4 i_data2,vec4 i_data3)
{
    mat4 model;
    model[0] = i_data0;
    model[1] = i_data1;
    model[2] = i_data2;
    ]odel[3] = i_data3;

    model[3].w = 1.0;

    return model;
}

#endif

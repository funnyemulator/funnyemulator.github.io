?GSN    ???!??7	2C-+Wi=iT@??T?a!?.0?͡ x[?Ӈ?T??0??M?pd?k	*n{?%R[3Y		?Š9gc??T1X?Ӫ?bB?(?y?????7??ɯ}!&?l?@.?h?.*???WDGH?(?@$??{?}?3?????a?-V??1?㶋??t????<+???~??7W!?`????n<q??\$9?6d݋?????!??P??!܅dzX{????????:r?.m {??ͅ??;~H????Y?!ot??????G+??\{??Pa?#N?A?????Ɩe?c̹??.+????X/??Y?f??^T^??f?PJ?i#?/?????$=?`???V?e?-?g??g7????@?????'?!!?i@????????$' ???Tvv?S??N?????L??r?&$???t??ZlRE??@??!???"???w a??k?F}U.?L?l*ږ??p???8ڝ??>???U<???اvYo;?VP?0 ?n?5)xC}?????@
    float blendWeight = a_weight.x;
    int matrixIndex = int (a_indices.x);
    _skinnedPosition += skinPosition(blendWeigh?, matrixIndex,a_position);
    blendWeight = a_weight.y;
    matrixIndex = int(a_indices.y);
    _skinnedPosition += skinPos:tion(blendWeight, matrixIndex,a_position);
//    blendWeight = a_weight.z;
//    matrixIndex = int(a_indices.z);
//    _skin?edPosition += skinPosition(blendWeight, matrixIndex,a_position);
//    blendWeight = a_weight.w;
//    matrixIndex = int(a_inices.w);
//    _skinnedPosition += skinPosition(blendWeight, matrixIndex,a_position);
    return _skinnedPosition;
}

vec3NskinTangentSpaceVector(vec3 norm, float blendWeight, int matrixIndex)
{
    vec3 tmp = vec3(1.0);
    tmp.x = dot(norm, u_ma?rixPalette[matrixIndex].xyz);
    tmp.y = dot(norm, u_matrixPalette[matrixIndex + 1].xyz);
    tmp.z = dot(norm, u_matrixPalete[matrixIndex + 2].xyz);
    return tmp * blendWeight;
}

vec3 getTangentSpaceVector(vec3 norm,vec4 a_weight,vec4 a_indice?)
{
    vec3 _skinnedNormal = vec3(0.0);
    // Transform normal to view space using matrix palette with four matrices used ?o transform a vertex.
    float blendWeight = a_weight.x;
    int matrixIndex = int (a_indices.x) * 3;
    _skinnedNormal +=JskinTangentSpaceVector(norm, blendWeight, matrixIndex);
    blendWeight = a_weight.y;
    matrixIndex = int(a_indices.y) * 3;~
    _skinnedNormal += skinTangentSpaceVector(norm, blendWeight, matrixIndex);
//    blendWeight = a_weight.z;
//    matrixInlex = int(a_indices.z) * 3;
//    _skinnedNormal += skinTangentSpaceVector(norm, blendWeight, matrixIndex);
//    blendWeight  a_weight.w;
//    matrixIndex = int(a_indices.w) * 3;
//    _skinnedNormal += skinTangentSpaceVector(norm, blendWeight, matr?xIndex);
    return _skinnedNormal;
}

vec3 getSkinnedNormal(vec3 a_normal,vec4 a_weight,vec4 a_indices)
{
    return getangentSpaceVector(a_normal,a_weight,a_indices);
}

#if defined(BUMPED)

vec3 getTangent()
{
    return getTangentSpaceVe?tor(a_tangent);
}

vec3 getBinormal()
{
    return getTangentSpaceVector(a_bitangent);
}
#endif


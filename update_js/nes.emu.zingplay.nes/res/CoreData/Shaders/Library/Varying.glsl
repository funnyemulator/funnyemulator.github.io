�GSN    �˅1��\7/5c:6pRRe&��v�Y�buQ���#uI����*�^�d��p�a<�B&/6�/>`]@���P~��T1X����'P�.`�/��ՙ�wː��^h�Wu�\�h�.n��[A~j��O]�vo�j�4�V�����E�6
k��!���㛘5ʤ��!����+J^:�N�̧�ol)��v0�.A��ק�?��)��o��>i.�������{&�c|>b������"mM��́�n!#WO������$m��q���x�|��ݴ�y5͹^�R����Dc����V?�W�H�'��:&.��#�oW�iN<������`>�A���_�m�d_��qTdcR��1����bI�=?�=����G���$@Hv׮R�ze�0{��H�����*q��q�-�7��U��;q=
&{��n���|��t���>'Z��Z�?[k�X�b ǈ��3��G����m�ŘyA��ϥy:~�&�0�f�NaR i��흣jt v_FragPos
    #endif
#endif

#ifdef USING_INOUT_SHADOWCOORD
    #ifdef VS
    $output v_shadowcoord
    #endif
    #i�def FS
    $input v_shadowcoord
    #endif
#endif

#ifdef USING_INOUT_POSITION
#ifdef VS
$output v_position
#endif
#if7ef FS
$input v_position
#endif
#endif

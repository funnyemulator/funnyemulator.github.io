�GSN    �˅1��\7,5V'pcw2toT��6�6e�$<غ�$^h����t�&�N��b�p<�N%�?zw/$֦�	}�tX���;��;gT�L�ײ��:ҋ��ec�T�Rr�:�!���Jn��Z<�vo�	Z�~�Mv��Ǌ��:Y��}�ċ���\����*�ǚ��eZs��ڿ�~l}��v<�;c���������H��E��>d,��������H�[vM������"cO���U�Py"4������+d��/��P;�'	�[�����BՏh�kʩ��o>饃�s�R�!�s��^H.��j�[3-�dj�F�^ѱ��h{�.����z�t�r��>[e���]�#�U����%�?m�C������5 \���+y�vP��B�����H	ϿQ�*�L��h��5Rx��K��X�|��=���1ax#���~k��x��Єv�ŻP��P��m4�э�\xN�62�z�l�lW?l ˆ���TIarying.glsl"

/// Common (uniforms,samplers, transforms ... )
#include "Library/Common.glsl"
#include "Library/Lighting.gls�"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex,v_texcoord0);
    gl_FragColor = vec4(texColor.rgb,texColor.a)h
}

#endif

�GSN    �˅1��\7,5V'Y 6Nh &[7��H�ah�,X{���.v@؞ΒA�J���.I� gu�&aC(5�MF-���w.G��e�̪�W�Zm�;ܢ���w҃��!k�Q,�sC��C/���	*y��Dp��#6��tS��ƌ�t�tUJ��2�����!����80����V'(J��˺�ACd��j4�->�Κ椣�3��K��.��|t#�������4t�gc5#BѬ����*7,׾��Z�Mfo1[J������$e��j��tn�wKE�X����#ڹI�y��;^����p�S�Z�3�ts\��g�*:�c@������$,�e�ܙ�i�"{�`��2*g��G�o�6�䣄+�!"�$U�竭`����*���00�S��D�	��R��l�|k�B��w��L+KΛ�� �Y��8���!([��c�0W9� �N6쵥�r�޼M��ŋhҬ�8>��¸vXop�E�yEA�)�3?U`-C��ꑣvf

#ifdef FS

#include "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
unifo�m mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniformsvec4 CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

uniform vec4 u_color;

void m�in()
{
    gl_FragColor = u_color;
}


#endif

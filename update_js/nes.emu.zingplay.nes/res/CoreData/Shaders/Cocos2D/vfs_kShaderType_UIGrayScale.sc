�GSN    �˅1��\7,5V'Y 6Nh &[7��H�ah�,yQ�Ű?s@Ł����'��v�y8�h9(/�}R2Q���wt�X1�Ѫ�-Y�>����Ӛԗ��`r�[�oP�)�|'޼�qGI��[H$�[&�\8�=�KU��Ů�m�6G�3f������z���1ؿ���w'n����o%9��$0�6x���؝Ʈ��M�B��si%����ϥ�E�
`<~4��ߓ��mU�����E2P@�㪃��,��?L��i�Ag�A�����<��l�x����cg����"v�[�!�i��X^c��f�G:Hd�N$�����jg�$���	�k[�Nz�P��*o���A�$�S����'�s�f���R����J}O_���,n�{3�Z�D�����e��8�&���h�51B��B��4�Ē��� L��m�@8[p�r�b�؞�zՄ�8ڝ�>��D5>��¸vXo~�&R�5\�v�mEoO#䕽��?, vec4(a_position.xyz,1.0));
    v_fragmentColor = a_color0;
    v_texCoord = a_texcoord0;
}


#endif

#ifdef FS

$in�ut v_fragmentColor, v_texCoord

#include "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPM2trix[4];
uniform mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_Normal�atrix;
uniform vec4 CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

SAMPLER2D (CC_Txture0,0);




void main()
{
    vec4 c = texture2D(CC_Texture0, v_texCoord);
    c = v_fragmentColor * c;
    gl_Frag-olor.xyz = vec3(0.2126*c.r + 0.7152*c.g + 0.0722*c.b);
    gl_FragColor.w = c.w;
}




#endif

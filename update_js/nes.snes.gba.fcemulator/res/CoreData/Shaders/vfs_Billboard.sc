�GSN    �˅1��\7,5V'pcw2toT��6�6e�$<غ�$^h����t�&�N��b�p<�N%�?zw/$֦�v�u����0W�C�}�����iΑ��rj�(�:/�g�a;���?-P��	�2+�\<��v\��꽷C�=o2��3������7����7���?��H4�����zFp��AG2�/#������>����;��ss%���冕��r�d|>{������-~@����S�Rd!iYE����ЋG~��`��^m�}
�j��Y�I�d̵��Y����{�S�E�V.��L!��#�\5+H�t$����ɔjx�9���O�-�<��% 7y���C�:�[����q	�0 �f�������))�� �0l�/x��U���	��UV��d�YF�o�;��^kRI��J��<���t���ciK/��h�^J.�Q� ����<���\����}أ�M4O�����?Zn:�ji�<4�]�8o  x�����q?   modelView[0][1] = 0.0; 
    modelView[0][2] = 0.0; 

    // Second colunm.
    modelView[1][0] = 0.0; 
    modelView[1]�1] = 1.0; 
    modelView[1][2] = 0.0; 

    // Thrid colunm.
    modelView[2][0] = 0.0; 
    modelView[2][1] = 0.0; 
    >odelView[2][2] = 1.0;

    // fixed-size billboard
    // https://stackoverflow.com/questions/41767490/how-to-transform-vert�ces-in-vertex-shader-to-get-a-3d-billboard

    vec4 viewPos = mul(u_modelView, u_billboardCenter);
    float dist = -viewPo	.z * 0.005;
    //gl_Position = mul(u_proj, (viewPos + vec4(a_position.xy*dist, 0, 0)));
    
    gl_Position = mul(u_proj, ul(modelView, vec4(a_position.xyz * dist, 1.0)));

    #include "Library/Macro/Texcoord0Final.glsl"
}

#endif

#ifdef FS�

/// input
#define USING_INOUT_TEXCOORD0
#include "Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )a
#include "Library/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex� v_texcoord0);
    gl_FragColor = vec4(texColor.rgb, texColor.a);
}

#endif

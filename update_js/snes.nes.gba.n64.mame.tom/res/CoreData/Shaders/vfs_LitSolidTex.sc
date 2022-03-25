�GSN    �˅1��\7,5V'pcw2toT��6�6e�$<غ�$^h����t�&�N��b�p<�N%�5py|pj���Rv��!B1��!�u�'aQ����Ӑu΁��UMo�Wy�I/�-�z+�΂GS]��Y{#]�TJ�#�%�Ww�����j�:��'�ȋ���A����8���}��G�?��E>��>P�伳�ݚ�5��J����SG+�֒�����I�Z)So��̻��!i����{�vE jv�ޙ�����a���>f�W�����`�c�m���lq����Y0��C�h��Y`��l�i+�i+������* �k���\�f�x]�3��85k���w� �S����1�^E�CB����R����i}O��R�y\+�0s��IÆ�$��U��8�(���t��V14M��C��9���^���wa��`�V4i����ܭr�޺����ۉ�M8��ؠ=:~�&�z�l�lW?l ˆ���TRacro/Texcoord0Final.glsl"
     #include "Library/Macro/ShadowCoordFinal.glsl"
     //#include "Library/Macro/FragPosFinal.gls�"

     v_FragPos = position.xyz;
}
#endif

#ifdef FS

/// input
#define USING_INOUT_NORMAL
#define USING_INOUT_TEXCORD0
#define USING_INOUT_SHADOWCOORD
#define USING_INOUT_FRAGPOS

#include "Library/Varying.glsl"

/// Common (uniforms,sa�plers, transforms ... )
#define RECEIVED_SHADOW
#include "Library/Common.glsl"
#include "Library/Lighting.glsl"

void mainR)
{
    vec4 texColor = texture2D(u_diffuseTex,v_texcoord0.xy);
    vec3 environmentColor = GetEnvironmentColor(v_normal);
N   vec3 lightColor = GetLightColor(v_normal);

    gl_FragColor = vec4((lightColor + environmentColor) * texColor.rgb,1.0);
�

#endif

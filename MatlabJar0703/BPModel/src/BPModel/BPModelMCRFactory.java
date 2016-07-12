/*
 * MATLAB Compiler: 4.14 (R2010b)
 * Date: Thu Jul 07 21:10:40 2016
 * Arguments: "-B" "macro_default" "-W" "java:BPModel,MatlabBP" "-T" "link:lib" "-d" 
 * "D:\\MatlabJar0703\\BPModel\\src" "-w" "enable:specified_file_mismatch" "-w" 
 * "enable:repeated_file" "-w" "enable:switch_ignored" "-w" "enable:missing_lib_sentinel" 
 * "-w" "enable:demo_license" "-v" 
 * "class{MatlabBP:C:\\Users\\C-Q\\Desktop\\训练的预测神经网络0703\\defaultderiv.m,C:\\Users\\C-Q\\Desktop\\训练的预测神经网络0703\\initzero.m,C:\\Users\\C-Q\\Desktop\\训练的预测神经网络0703\\learngdm.m,C:\\Users\\C-Q\\Desktop\\训练的预测神经网络0703\\mapminmax2.m,C:\\Users\\C-Q\\Desktop\\训练的预测神经网络0703\\predict0707.m,C:\\Users\\C-Q\\Desktop\\训练的预测神经网络0703\\sim2.m,C:\\Users\\C-Q\\Desktop\\训练的预测神经网络0703\\struct2.m}" 
 */

package BPModel;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class BPModelMCRFactory
{
   
    
    /** Component's uuid */
    private static final String sComponentId = "BPModel_BD14BFB593055837266ADE4F7CE51BFD";
    
    /** Component name */
    private static final String sComponentName = "BPModel";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(BPModelMCRFactory.class)
        );
    
    
    private BPModelMCRFactory()
    {
        // Never called.
    }
    
    public static MWMCR newInstance(MWComponentOptions componentOptions) throws MWException
    {
        if (null == componentOptions.getCtfSource()) {
            componentOptions = new MWComponentOptions(componentOptions);
            componentOptions.setCtfSource(sDefaultComponentOptions.getCtfSource());
        }
        return MWMCR.newInstance(
            componentOptions, 
            BPModelMCRFactory.class, 
            sComponentName, 
            sComponentId,
            new int[]{7,14,0}
        );
    }
    
    public static MWMCR newInstance() throws MWException
    {
        return newInstance(sDefaultComponentOptions);
    }
}

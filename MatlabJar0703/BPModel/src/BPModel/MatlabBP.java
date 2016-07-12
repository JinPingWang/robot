/*
 * MATLAB Compiler: 4.14 (R2010b)
 * Date: Thu Jul 07 21:10:40 2016
 * Arguments: "-B" "macro_default" "-W" "java:BPModel,MatlabBP" "-T" "link:lib" "-d" 
 * "D:\\MatlabJar0703\\BPModel\\src" "-w" "enable:specified_file_mismatch" "-w" 
 * "enable:repeated_file" "-w" "enable:switch_ignored" "-w" "enable:missing_lib_sentinel" 
 * "-w" "enable:demo_license" "-v" 
 * "class{MatlabBP:C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\defaultderiv.m,C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\initzero.m,C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\learngdm.m,C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\mapminmax2.m,C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\predict0707.m,C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\sim2.m,C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\struct2.m}" 
 */

package BPModel;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;
import java.util.*;

/**
 * The <code>MatlabBP</code> class provides a Java interface to the M-functions
 * from the files:
 * <pre>
 *  C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\defaultderiv.m
 *  C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\initzero.m
 *  C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\learngdm.m
 *  C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\mapminmax2.m
 *  C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\predict0707.m
 *  C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\sim2.m
 *  C:\\Users\\C-Q\\Desktop\\ÑµÁ·µÄÔ¤²âÉñ¾­ÍøÂç0703\\struct2.m
 * </pre>
 * The {@link #dispose} method <b>must</b> be called on a <code>MatlabBP</code> instance 
 * when it is no longer needed to ensure that native resources allocated by this class 
 * are properly freed.
 * @version 0.0
 */
public class MatlabBP extends MWComponentInstance<MatlabBP>
{
    /**
     * Tracks all instances of this class to ensure their dispose method is
     * called on shutdown.
     */
    private static final Set<Disposable> sInstances = new HashSet<Disposable>();

    /**
     * Maintains information used in calling the <code>defaultderiv</code> M-function.
     */
    private static final MWFunctionSignature sDefaultderivSignature =
        new MWFunctionSignature(/* max outputs = */ 1,
                                /* has varargout = */ false,
                                /* function name = */ "defaultderiv",
                                /* max inputs = */ 7,
                                /* has varargin = */ false);
    /**
     * Maintains information used in calling the <code>initzero</code> M-function.
     */
    private static final MWFunctionSignature sInitzeroSignature =
        new MWFunctionSignature(/* max outputs = */ 1,
                                /* has varargout = */ false,
                                /* function name = */ "initzero",
                                /* max inputs = */ 6,
                                /* has varargin = */ false);
    /**
     * Maintains information used in calling the <code>learngdm</code> M-function.
     */
    private static final MWFunctionSignature sLearngdmSignature =
        new MWFunctionSignature(/* max outputs = */ 2,
                                /* has varargout = */ false,
                                /* function name = */ "learngdm",
                                /* max inputs = */ 1,
                                /* has varargin = */ true);
    /**
     * Maintains information used in calling the <code>mapminmax2</code> M-function.
     */
    private static final MWFunctionSignature sMapminmax2Signature =
        new MWFunctionSignature(/* max outputs = */ 2,
                                /* has varargout = */ false,
                                /* function name = */ "mapminmax2",
                                /* max inputs = */ 1,
                                /* has varargin = */ true);
    /**
     * Maintains information used in calling the <code>predict0707</code> M-function.
     */
    private static final MWFunctionSignature sPredict0707Signature =
        new MWFunctionSignature(/* max outputs = */ 1,
                                /* has varargout = */ false,
                                /* function name = */ "predict0707",
                                /* max inputs = */ 1,
                                /* has varargin = */ false);
    /**
     * Maintains information used in calling the <code>sim2</code> M-function.
     */
    private static final MWFunctionSignature sSim2Signature =
        new MWFunctionSignature(/* max outputs = */ 5,
                                /* has varargout = */ false,
                                /* function name = */ "sim2",
                                /* max inputs = */ 2,
                                /* has varargin = */ true);
    /**
     * Maintains information used in calling the <code>struct2</code> M-function.
     */
    private static final MWFunctionSignature sStruct2Signature =
        new MWFunctionSignature(/* max outputs = */ 1,
                                /* has varargout = */ false,
                                /* function name = */ "struct2",
                                /* max inputs = */ 1,
                                /* has varargin = */ false);

    /**
     * Shared initialization implementation - private
     */
    private MatlabBP (final MWMCR mcr) throws MWException
    {
        super(mcr);
        // add this to sInstances
        synchronized(MatlabBP.class) {
            sInstances.add(this);
        }
    }

    /**
     * Constructs a new instance of the <code>MatlabBP</code> class.
     */
    public MatlabBP() throws MWException
    {
        this(BPModelMCRFactory.newInstance());
    }
    
    private static MWComponentOptions getPathToComponentOptions(String path)
    {
        MWComponentOptions options = new MWComponentOptions(new MWCtfExtractLocation(path),
                                                            new MWCtfDirectorySource(path));
        return options;
    }
    
    /**
     * @deprecated Please use the constructor {@link #MatlabBP(MWComponentOptions componentOptions)}.
     * The <code>com.mathworks.toolbox.javabuilder.MWComponentOptions</code> class provides API to set the
     * path to the component.
     * @param pathToComponent Path to component directory.
     */
    public MatlabBP(String pathToComponent) throws MWException
    {
        this(BPModelMCRFactory.newInstance(getPathToComponentOptions(pathToComponent)));
    }
    
    /**
     * Constructs a new instance of the <code>MatlabBP</code> class. Use this constructor 
     * to specify the options required to instantiate this component.  The options will 
     * be specific to the instance of this component being created.
     * @param componentOptions Options specific to the component.
     */
    public MatlabBP(MWComponentOptions componentOptions) throws MWException
    {
        this(BPModelMCRFactory.newInstance(componentOptions));
    }
    
    /** Frees native resources associated with this object */
    public void dispose()
    {
        try {
            super.dispose();
        } finally {
            synchronized(MatlabBP.class) {
                sInstances.remove(this);
            }
        }
    }
  
    /**
     * Invokes the first m-function specified by MCC, with any arguments given on
     * the command line, and prints the result.
     */
    public static void main (String[] args)
    {
        try {
            MWMCR mcr = BPModelMCRFactory.newInstance();
            mcr.runMain( sDefaultderivSignature, args);
            mcr.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    /**
     * Calls dispose method for each outstanding instance of this class.
     */
    public static void disposeAllInstances()
    {
        synchronized(MatlabBP.class) {
            for (Disposable i : sInstances) i.dispose();
            sInstances.clear();
        }
    }

    /**
     * Provides the interface for calling the <code>defaultderiv</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %DEFAULTDERIV Default derivative function.
     * %
     * %  <a href="matlab:doc 
     * defaultderiv">defaultderiv</a>('dperf_dwb',net,X,T,Xi,Ai,EW) takes a network, 
     * inputs X,
     * %  targets T, initial input states Xi, initial layer states Ai, and error
     * %  weights EW, and returns the gradient, the derivative of performance with
     * %  respect to the network's weights and biases.
     * %
     * %  <a href="matlab:doc defaultderiv">defaultderiv</a>('de_dwb',net,X,T,Xi,Ai,EW) 
     * returns the Jacobian, the
     * %  derivative of each error with respect to the network's weights and biases.
     * %
     * %  <a href="matlab:doc defaultderiv">defaultderiv</a> chooses the derivative 
     * algorithm most likely to be
     * %  efficient based on whether a network is static or dynamic.
     * %
     * %  If the network is static, then <a href="matlab:doc staticderiv">staticderiv</a> 
     * is used to calculate the
     * %  gradient or Jacobian.  If the network is dynamic then <a href="matlab:doc 
     * bttderiv">bttderiv</a> is used
     * %  to calculate the gradient, and <a href="matlab:doc fpderiv">fpderiv</a> is used 
     * for the Jacobian.
     * %
     * %  Here a feedforward network is trained and derivatives calculated.
     * %
     * %    [x,t] = <a href="matlab:doc simplefit_dataset">simplefit_dataset</a>;
     * %    net = <a href="matlab:doc feedforwardnet">feedforwardnet</a>(10);
     * %    net = <a href="matlab:doc train">train</a>(net,x,t);
     * %    y = net(x);
     * %    perf = <a href="matlab:doc perform">perform</a>(net,t,y)
     * %    dwb = <a href="matlab:doc defaultderiv">defaultderiv</a>('dperf_dwb',net,x,t)
     * %
     * %  See also STATICDERIV, BTTDERIV, FPDERIV.
     * </pre>
     * </p>
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void defaultderiv(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sDefaultderivSignature);
    }

    /**
     * Provides the interface for calling the <code>defaultderiv</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %DEFAULTDERIV Default derivative function.
     * %
     * %  <a href="matlab:doc 
     * defaultderiv">defaultderiv</a>('dperf_dwb',net,X,T,Xi,Ai,EW) takes a network, 
     * inputs X,
     * %  targets T, initial input states Xi, initial layer states Ai, and error
     * %  weights EW, and returns the gradient, the derivative of performance with
     * %  respect to the network's weights and biases.
     * %
     * %  <a href="matlab:doc defaultderiv">defaultderiv</a>('de_dwb',net,X,T,Xi,Ai,EW) 
     * returns the Jacobian, the
     * %  derivative of each error with respect to the network's weights and biases.
     * %
     * %  <a href="matlab:doc defaultderiv">defaultderiv</a> chooses the derivative 
     * algorithm most likely to be
     * %  efficient based on whether a network is static or dynamic.
     * %
     * %  If the network is static, then <a href="matlab:doc staticderiv">staticderiv</a> 
     * is used to calculate the
     * %  gradient or Jacobian.  If the network is dynamic then <a href="matlab:doc 
     * bttderiv">bttderiv</a> is used
     * %  to calculate the gradient, and <a href="matlab:doc fpderiv">fpderiv</a> is used 
     * for the Jacobian.
     * %
     * %  Here a feedforward network is trained and derivatives calculated.
     * %
     * %    [x,t] = <a href="matlab:doc simplefit_dataset">simplefit_dataset</a>;
     * %    net = <a href="matlab:doc feedforwardnet">feedforwardnet</a>(10);
     * %    net = <a href="matlab:doc train">train</a>(net,x,t);
     * %    y = net(x);
     * %    perf = <a href="matlab:doc perform">perform</a>(net,t,y)
     * %    dwb = <a href="matlab:doc defaultderiv">defaultderiv</a>('dperf_dwb',net,x,t)
     * %
     * %  See also STATICDERIV, BTTDERIV, FPDERIV.
     * </pre>
     * </p>
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void defaultderiv(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sDefaultderivSignature);
    }

    /**
     * Provides the standard interface for calling the <code>defaultderiv</code>
     * M-function with 7 input arguments.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %DEFAULTDERIV Default derivative function.
     * %
     * %  <a href="matlab:doc 
     * defaultderiv">defaultderiv</a>('dperf_dwb',net,X,T,Xi,Ai,EW) takes a network, 
     * inputs X,
     * %  targets T, initial input states Xi, initial layer states Ai, and error
     * %  weights EW, and returns the gradient, the derivative of performance with
     * %  respect to the network's weights and biases.
     * %
     * %  <a href="matlab:doc defaultderiv">defaultderiv</a>('de_dwb',net,X,T,Xi,Ai,EW) 
     * returns the Jacobian, the
     * %  derivative of each error with respect to the network's weights and biases.
     * %
     * %  <a href="matlab:doc defaultderiv">defaultderiv</a> chooses the derivative 
     * algorithm most likely to be
     * %  efficient based on whether a network is static or dynamic.
     * %
     * %  If the network is static, then <a href="matlab:doc staticderiv">staticderiv</a> 
     * is used to calculate the
     * %  gradient or Jacobian.  If the network is dynamic then <a href="matlab:doc 
     * bttderiv">bttderiv</a> is used
     * %  to calculate the gradient, and <a href="matlab:doc fpderiv">fpderiv</a> is used 
     * for the Jacobian.
     * %
     * %  Here a feedforward network is trained and derivatives calculated.
     * %
     * %    [x,t] = <a href="matlab:doc simplefit_dataset">simplefit_dataset</a>;
     * %    net = <a href="matlab:doc feedforwardnet">feedforwardnet</a>(10);
     * %    net = <a href="matlab:doc train">train</a>(net,x,t);
     * %    y = net(x);
     * %    perf = <a href="matlab:doc perform">perform</a>(net,t,y)
     * %    dwb = <a href="matlab:doc defaultderiv">defaultderiv</a>('dperf_dwb',net,x,t)
     * %
     * %  See also STATICDERIV, BTTDERIV, FPDERIV.
     * </pre>
     * </p>
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] defaultderiv(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sDefaultderivSignature), 
                    sDefaultderivSignature);
        return lhs;
    }
    /**
     * Provides the interface for calling the <code>initzero</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %INITZERO Zero weight/bias initialization function.
     * %  
     * %  INITZERO can be used as a weight or bias initialization function.
     * %
     * %  INITZERO(S,R) takes a number of rows (columns) S and number of inputs
     * %  (columns) R and returns and SxR zero matrix.
     * %
     * %  See also INITWB, INITLAY, INIT.
     * </pre>
     * </p>
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void initzero(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sInitzeroSignature);
    }

    /**
     * Provides the interface for calling the <code>initzero</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %INITZERO Zero weight/bias initialization function.
     * %  
     * %  INITZERO can be used as a weight or bias initialization function.
     * %
     * %  INITZERO(S,R) takes a number of rows (columns) S and number of inputs
     * %  (columns) R and returns and SxR zero matrix.
     * %
     * %  See also INITWB, INITLAY, INIT.
     * </pre>
     * </p>
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void initzero(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sInitzeroSignature);
    }

    /**
     * Provides the standard interface for calling the <code>initzero</code>
     * M-function with 6 input arguments.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %INITZERO Zero weight/bias initialization function.
     * %  
     * %  INITZERO can be used as a weight or bias initialization function.
     * %
     * %  INITZERO(S,R) takes a number of rows (columns) S and number of inputs
     * %  (columns) R and returns and SxR zero matrix.
     * %
     * %  See also INITWB, INITLAY, INIT.
     * </pre>
     * </p>
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] initzero(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sInitzeroSignature), 
                    sInitzeroSignature);
        return lhs;
    }
    /**
     * Provides the interface for calling the <code>learngdm</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %LEARNGDM Gradient descent w/momentum weight/bias learning function.
     * %  
     * %  <a href="matlab:doc learngdm">learngdm</a> is the gradient descent with 
     * momentum weight/bias
     * %  learning function.
     * %  
     * %  <a href="matlab:doc learngdm">learngdm</a>(W,P,Z,N,A,T,E,gW,gA,D,LP,LS) takes 
     * several inputs,
     * %    W  - SxR weight matrix (or Sx1 bias vector).
     * %    P  - RxQ input vectors (or ones(1,Q)).
     * %    Z  - SxQ weighted input vectors.
     * %    N  - SxQ net input vectors.
     * %    A  - SxQ output vectors.
     * %    T  - SxQ layer target vectors.
     * %    E  - SxQ layer error vectors.
     * %    gW - SxR gradient with respect to performance.
     * %    gA - SxQ output gradient with respect to performance.
     * %    D  - SxS neuron distances.
     * %    LP - Learning parameters, none, LP = [].
     * %    LS - Learning state, initially should be = [].
     * %  and returns,
     * %    dW - SxR weight (or bias) change matrix.
     * %    LS - New learning state.
     * %
     * %  Learning occurs according to LEARNGDM's learning parameters,
     * %  shown here with their default values.
     * %    LP.lr - 0.01 - Learning rate
     * %    LP.mc - 0.9  - Momentum constant
     * %
     * %  <a href="matlab:doc learngdm">learngdm</a>(CODE) returns useful information for 
     * each CODE string:
     * %    'pnames'    - Returns names of learning parameters.
     * %    'pdefaults' - Returns default learning parameters.
     * %    'needg'     - Returns 1 if this function uses gW or gA.
     * %
     * %  Here we define a random gradient G for a weight going
     * %  to a layer with 3 neurons, from an input with 2 elements.
     * %  We also define a learning rate of 0.5 and momentum constant
     * %  of 0.8;
     * %
     * %    gW = rand(3,2);
     * %    lp.lr = 0.5;
     * %    lp.mc = 0.8;
     * %
     * %  <a href="matlab:doc learngdm">learngdm</a> only needs these values to calculate 
     * a weight
     * %  change. We will use the default initial learning state.
     * % 
     * %    ls = [];
     * %    [dW,ls] = <a href="matlab:doc 
     * learngdm">learngdm</a>([],[],[],[],[],[],[],gW,[],[],lp,ls)
     * %
     * %  See also LEARNGD, NEWFF, NEWCF, ADAPT, TRAIN.
     * </pre>
     * </p>
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void learngdm(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sLearngdmSignature);
    }

    /**
     * Provides the interface for calling the <code>learngdm</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %LEARNGDM Gradient descent w/momentum weight/bias learning function.
     * %  
     * %  <a href="matlab:doc learngdm">learngdm</a> is the gradient descent with 
     * momentum weight/bias
     * %  learning function.
     * %  
     * %  <a href="matlab:doc learngdm">learngdm</a>(W,P,Z,N,A,T,E,gW,gA,D,LP,LS) takes 
     * several inputs,
     * %    W  - SxR weight matrix (or Sx1 bias vector).
     * %    P  - RxQ input vectors (or ones(1,Q)).
     * %    Z  - SxQ weighted input vectors.
     * %    N  - SxQ net input vectors.
     * %    A  - SxQ output vectors.
     * %    T  - SxQ layer target vectors.
     * %    E  - SxQ layer error vectors.
     * %    gW - SxR gradient with respect to performance.
     * %    gA - SxQ output gradient with respect to performance.
     * %    D  - SxS neuron distances.
     * %    LP - Learning parameters, none, LP = [].
     * %    LS - Learning state, initially should be = [].
     * %  and returns,
     * %    dW - SxR weight (or bias) change matrix.
     * %    LS - New learning state.
     * %
     * %  Learning occurs according to LEARNGDM's learning parameters,
     * %  shown here with their default values.
     * %    LP.lr - 0.01 - Learning rate
     * %    LP.mc - 0.9  - Momentum constant
     * %
     * %  <a href="matlab:doc learngdm">learngdm</a>(CODE) returns useful information for 
     * each CODE string:
     * %    'pnames'    - Returns names of learning parameters.
     * %    'pdefaults' - Returns default learning parameters.
     * %    'needg'     - Returns 1 if this function uses gW or gA.
     * %
     * %  Here we define a random gradient G for a weight going
     * %  to a layer with 3 neurons, from an input with 2 elements.
     * %  We also define a learning rate of 0.5 and momentum constant
     * %  of 0.8;
     * %
     * %    gW = rand(3,2);
     * %    lp.lr = 0.5;
     * %    lp.mc = 0.8;
     * %
     * %  <a href="matlab:doc learngdm">learngdm</a> only needs these values to calculate 
     * a weight
     * %  change. We will use the default initial learning state.
     * % 
     * %    ls = [];
     * %    [dW,ls] = <a href="matlab:doc 
     * learngdm">learngdm</a>([],[],[],[],[],[],[],gW,[],[],lp,ls)
     * %
     * %  See also LEARNGD, NEWFF, NEWCF, ADAPT, TRAIN.
     * </pre>
     * </p>
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void learngdm(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sLearngdmSignature);
    }

    /**
     * Provides the standard interface for calling the <code>learngdm</code>
     * M-function with 1 input argument.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %LEARNGDM Gradient descent w/momentum weight/bias learning function.
     * %  
     * %  <a href="matlab:doc learngdm">learngdm</a> is the gradient descent with 
     * momentum weight/bias
     * %  learning function.
     * %  
     * %  <a href="matlab:doc learngdm">learngdm</a>(W,P,Z,N,A,T,E,gW,gA,D,LP,LS) takes 
     * several inputs,
     * %    W  - SxR weight matrix (or Sx1 bias vector).
     * %    P  - RxQ input vectors (or ones(1,Q)).
     * %    Z  - SxQ weighted input vectors.
     * %    N  - SxQ net input vectors.
     * %    A  - SxQ output vectors.
     * %    T  - SxQ layer target vectors.
     * %    E  - SxQ layer error vectors.
     * %    gW - SxR gradient with respect to performance.
     * %    gA - SxQ output gradient with respect to performance.
     * %    D  - SxS neuron distances.
     * %    LP - Learning parameters, none, LP = [].
     * %    LS - Learning state, initially should be = [].
     * %  and returns,
     * %    dW - SxR weight (or bias) change matrix.
     * %    LS - New learning state.
     * %
     * %  Learning occurs according to LEARNGDM's learning parameters,
     * %  shown here with their default values.
     * %    LP.lr - 0.01 - Learning rate
     * %    LP.mc - 0.9  - Momentum constant
     * %
     * %  <a href="matlab:doc learngdm">learngdm</a>(CODE) returns useful information for 
     * each CODE string:
     * %    'pnames'    - Returns names of learning parameters.
     * %    'pdefaults' - Returns default learning parameters.
     * %    'needg'     - Returns 1 if this function uses gW or gA.
     * %
     * %  Here we define a random gradient G for a weight going
     * %  to a layer with 3 neurons, from an input with 2 elements.
     * %  We also define a learning rate of 0.5 and momentum constant
     * %  of 0.8;
     * %
     * %    gW = rand(3,2);
     * %    lp.lr = 0.5;
     * %    lp.mc = 0.8;
     * %
     * %  <a href="matlab:doc learngdm">learngdm</a> only needs these values to calculate 
     * a weight
     * %  change. We will use the default initial learning state.
     * % 
     * %    ls = [];
     * %    [dW,ls] = <a href="matlab:doc 
     * learngdm">learngdm</a>([],[],[],[],[],[],[],gW,[],[],lp,ls)
     * %
     * %  See also LEARNGD, NEWFF, NEWCF, ADAPT, TRAIN.
     * </pre>
     * </p>
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] learngdm(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sLearngdmSignature), 
                    sLearngdmSignature);
        return lhs;
    }
    /**
     * Provides the interface for calling the <code>mapminmax2</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %MAPMINMAX Map matrix row minimum and maximum values to [-1 1].
     * % 
     * % <a href="matlab:doc mapminmax">mapminmax</a> processes input and target data by 
     * mapping it from its original
     * % range to the range [-1 1].
     * %
     * % [Y,settings] = <a href="matlab:doc mapminmax">mapminmax</a>(X) takes matrix or 
     * cell array neural data,
     * % returns it transformed with the settings used to perform the transform.
     * %
     * % Here random data with non-standard ranges in each row is transformed.
     * %
     * %   x1 = [rand(1,20)*5-1; rand(1,20)*20-10; rand(1,20)-1];
     * %   [y1,settings] = <a href="matlab:doc mapminmax">mapminmax</a>(x1)
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('apply',X,settings) transforms X 
     * consistent with settings
     * % returned by a previous transformation.
     * %
     * %   x2 = [rand(1,20)*5-1; rand(1,20)*20-10; rand(1,20)-1];
     * %   y2 = <a href="matlab:doc mapminmax">mapminmax</a>('apply',x2,settings)
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('reverse',Y,settings) reverse 
     * transforms Y consistent with
     * % settings returned by a previous transformation.
     * %
     * %   x1_again = <a href="matlab:doc mapminmax">mapminmax</a>('reverse',y1,settings)
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('dy_dx',X,Y,settings) returns the 
     * transformation derivative
     * % of Y with respect to X.
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('dx_dy',X,Y,settings) returns the 
     * reverse transformation
     * % derivative of X with respect to Y.
     * %
     * % See also MAPSTD, PROCESSPCA, REMOVECONSTANTROWS.
     * </pre>
     * </p>
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void mapminmax2(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sMapminmax2Signature);
    }

    /**
     * Provides the interface for calling the <code>mapminmax2</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %MAPMINMAX Map matrix row minimum and maximum values to [-1 1].
     * % 
     * % <a href="matlab:doc mapminmax">mapminmax</a> processes input and target data by 
     * mapping it from its original
     * % range to the range [-1 1].
     * %
     * % [Y,settings] = <a href="matlab:doc mapminmax">mapminmax</a>(X) takes matrix or 
     * cell array neural data,
     * % returns it transformed with the settings used to perform the transform.
     * %
     * % Here random data with non-standard ranges in each row is transformed.
     * %
     * %   x1 = [rand(1,20)*5-1; rand(1,20)*20-10; rand(1,20)-1];
     * %   [y1,settings] = <a href="matlab:doc mapminmax">mapminmax</a>(x1)
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('apply',X,settings) transforms X 
     * consistent with settings
     * % returned by a previous transformation.
     * %
     * %   x2 = [rand(1,20)*5-1; rand(1,20)*20-10; rand(1,20)-1];
     * %   y2 = <a href="matlab:doc mapminmax">mapminmax</a>('apply',x2,settings)
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('reverse',Y,settings) reverse 
     * transforms Y consistent with
     * % settings returned by a previous transformation.
     * %
     * %   x1_again = <a href="matlab:doc mapminmax">mapminmax</a>('reverse',y1,settings)
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('dy_dx',X,Y,settings) returns the 
     * transformation derivative
     * % of Y with respect to X.
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('dx_dy',X,Y,settings) returns the 
     * reverse transformation
     * % derivative of X with respect to Y.
     * %
     * % See also MAPSTD, PROCESSPCA, REMOVECONSTANTROWS.
     * </pre>
     * </p>
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void mapminmax2(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sMapminmax2Signature);
    }

    /**
     * Provides the standard interface for calling the <code>mapminmax2</code>
     * M-function with 1 input argument.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %MAPMINMAX Map matrix row minimum and maximum values to [-1 1].
     * % 
     * % <a href="matlab:doc mapminmax">mapminmax</a> processes input and target data by 
     * mapping it from its original
     * % range to the range [-1 1].
     * %
     * % [Y,settings] = <a href="matlab:doc mapminmax">mapminmax</a>(X) takes matrix or 
     * cell array neural data,
     * % returns it transformed with the settings used to perform the transform.
     * %
     * % Here random data with non-standard ranges in each row is transformed.
     * %
     * %   x1 = [rand(1,20)*5-1; rand(1,20)*20-10; rand(1,20)-1];
     * %   [y1,settings] = <a href="matlab:doc mapminmax">mapminmax</a>(x1)
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('apply',X,settings) transforms X 
     * consistent with settings
     * % returned by a previous transformation.
     * %
     * %   x2 = [rand(1,20)*5-1; rand(1,20)*20-10; rand(1,20)-1];
     * %   y2 = <a href="matlab:doc mapminmax">mapminmax</a>('apply',x2,settings)
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('reverse',Y,settings) reverse 
     * transforms Y consistent with
     * % settings returned by a previous transformation.
     * %
     * %   x1_again = <a href="matlab:doc mapminmax">mapminmax</a>('reverse',y1,settings)
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('dy_dx',X,Y,settings) returns the 
     * transformation derivative
     * % of Y with respect to X.
     * %
     * % <a href="matlab:doc mapminmax">mapminmax</a>('dx_dy',X,Y,settings) returns the 
     * reverse transformation
     * % derivative of X with respect to Y.
     * %
     * % See also MAPSTD, PROCESSPCA, REMOVECONSTANTROWS.
     * </pre>
     * </p>
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] mapminmax2(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sMapminmax2Signature), 
                    sMapminmax2Signature);
        return lhs;
    }
    /**
     * Provides the interface for calling the <code>predict0707</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %i am not happy.
     *     %save('d:\\MatlabJar0703\\BPModel0707.mat', 'net');
     * </pre>
     * </p>
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void predict0707(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sPredict0707Signature);
    }

    /**
     * Provides the interface for calling the <code>predict0707</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %i am not happy.
     *     %save('d:\\MatlabJar0703\\BPModel0707.mat', 'net');
     * </pre>
     * </p>
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void predict0707(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sPredict0707Signature);
    }

    /**
     * Provides the standard interface for calling the <code>predict0707</code>
     * M-function with 1 input argument.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %i am not happy.
     *     %save('d:\\MatlabJar0703\\BPModel0707.mat', 'net');
     * </pre>
     * </p>
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] predict0707(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sPredict0707Signature), 
                    sPredict0707Signature);
        return lhs;
    }
    /**
     * Provides the interface for calling the <code>sim2</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %SIM Simulate a neural network.
     * %
     * %  SIM(NET,X) takes a network NET and inputs X and returns the outputs
     * %  Y generated by the network.  This syntax is equivalent to NET(X).
     * %
     * %  [Y,Xf,Af] = <a href="matlab:doc sim">sim</a>(NET,X,Xi,Ai) takes a dynamic 
     * network NET, inputs X,
     * %  and initial input and layer delays Xi and Ai.  It returns the outputs Y
     * %  and final input and layer delays states Xf and Af.
     * %
     * %  <a href="matlab:doc sim">sim</a> arguments can have two formats: matrices, for 
     * static
     * %  problems and networks with single inputs and outputs, and cell arrays
     * %  for multiple timesteps and networks with multiple inputs and outputs.
     * %
     * %  The matrix format is as follows:
     * %    X  - RxQ matrix
     * %    Y  - UxQ matrix.
     * %  Where:
     * %    Q  = number of samples
     * %    R  = number of elements in the network's input
     * %    U  = number of elements in the network's output
     * %
     * %  The cell array format is most general:
     * %    X  - NixTS cell array, each element X{i,ts} is an RixQ matrix.
     * %    Xi - NixID cell array, each element Xi{i,k} is an RixQ matrix.
     * %    Ai - NlxLD cell array, each element Ai{i,k} is an SixQ matrix.
     * %    Y  - NOxTS cell array, each element Y{i,ts} is a UixQ matrix.
     * %    Xf - NixID cell array, each element Xf{i,k} is an RixQ matrix.
     * %    Af - NlxLD cell array, each element Af{i,k} is an SixQ matrix.
     * %  Where:
     * %    TS = number of time steps
     * %    Ni = NET.<a href="matlab:doc nnproperty.net_numInputs">numInputs</a>
     * %    Nl = NET.<a href="matlab:doc nnproperty.net_numLayers">numLayers</a>, 
     * %    No = NET.<a href="matlab:doc nnproperty.net_numOutputs">numOutputs</a>
     * %    ID = NET.<a href="matlab:doc nnproperty.net_numInputDelays">numInputDelays</a>
     * %    LD = NET.<a href="matlab:doc nnproperty.net_numLayerDelays">numLayerDelays</a>
     * %    Ri = NET.<a href="matlab:doc nnproperty.net_inputs">inputs</a>{i}.<a 
     * href="matlab:doc nnproperty.input_size">size</a>
     * %    Si = NET.<a href="matlab:doc nnproperty.net_layers">layers</a>{i}.<a 
     * href="matlab:doc nnproperty.layer_size">size</a>
     * %    Ui = NET.<a href="matlab:doc nnproperty.net_outputs">outputs</a>{i}.<a 
     * href="matlab:doc nnproperty.output_size">size</a>
     * %
     * %  The columns of Xi, Xf, Ai, and Af are ordered from oldest delay
     * %  condition to most recent:
     * %    Xi{i,k} = input i at time ts=k-ID.
     * %    Xf{i,k} = input i at time ts=TS+k-ID.
     * %    Ai{i,k} = layer output i at time ts=k-LD.
     * %    Af{i,k} = layer output i at time ts=TS+k-LD.
     * %
     * %  [Y,Pf,Af] = SIM(net,{Q TS},Pi,Ai) is used for networks
     * %  which do not have an input, such as Hopfield networks
     * %  when cell array notation is used.
     * %
     * %  Here a static feedforward network is created, trained on some data, then
     * %  simulated using SIM and network notation.
     * %
     * %    [x,t] = <a href="matlab:doc simplefit_dataset">simplefit_dataset</a>;
     * %    net = <a href="matlab:doc feedforwardnet">feedforwardnet</a>(10);
     * %    net = <a href="matlab:doc train">train</a>(net,x,t);
     * %    y1 = <a href="matlab:doc sim">sim</a>(net,x)
     * %    y2 = net(x)
     * %
     * %  Here a dynamic NARX network is created, trained, and simulated on
     * %  time series data.
     * %
     * %   [X,T] = <a href="matlab:doc simplenarx_dataset">simplenarx_dataset</a>;
     * %   net = <a href="matlab:doc narxnet">narxnet</a>(1:2,1:2,10);
     * %   <a href="matlab:doc view">view</a>(net)
     * %   [Xs,Xi,Ai,Ts] = <a href="matlab:doc preparets">preparets</a>(net,X,{},T);
     * %   net = <a href="matlab:doc train">train</a>(net,Xs,Ts,Xi,Ai);
     * %   Y1 = <a href="matlab:doc sim">sim</a>(net,Xs,Xi,Ai)
     * %   Y2 = net(Xs,Xi,Ai)
     * %
     * %  See also INIT, REVERT, ADAPT, TRAIN
     * </pre>
     * </p>
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void sim2(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sSim2Signature);
    }

    /**
     * Provides the interface for calling the <code>sim2</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %SIM Simulate a neural network.
     * %
     * %  SIM(NET,X) takes a network NET and inputs X and returns the outputs
     * %  Y generated by the network.  This syntax is equivalent to NET(X).
     * %
     * %  [Y,Xf,Af] = <a href="matlab:doc sim">sim</a>(NET,X,Xi,Ai) takes a dynamic 
     * network NET, inputs X,
     * %  and initial input and layer delays Xi and Ai.  It returns the outputs Y
     * %  and final input and layer delays states Xf and Af.
     * %
     * %  <a href="matlab:doc sim">sim</a> arguments can have two formats: matrices, for 
     * static
     * %  problems and networks with single inputs and outputs, and cell arrays
     * %  for multiple timesteps and networks with multiple inputs and outputs.
     * %
     * %  The matrix format is as follows:
     * %    X  - RxQ matrix
     * %    Y  - UxQ matrix.
     * %  Where:
     * %    Q  = number of samples
     * %    R  = number of elements in the network's input
     * %    U  = number of elements in the network's output
     * %
     * %  The cell array format is most general:
     * %    X  - NixTS cell array, each element X{i,ts} is an RixQ matrix.
     * %    Xi - NixID cell array, each element Xi{i,k} is an RixQ matrix.
     * %    Ai - NlxLD cell array, each element Ai{i,k} is an SixQ matrix.
     * %    Y  - NOxTS cell array, each element Y{i,ts} is a UixQ matrix.
     * %    Xf - NixID cell array, each element Xf{i,k} is an RixQ matrix.
     * %    Af - NlxLD cell array, each element Af{i,k} is an SixQ matrix.
     * %  Where:
     * %    TS = number of time steps
     * %    Ni = NET.<a href="matlab:doc nnproperty.net_numInputs">numInputs</a>
     * %    Nl = NET.<a href="matlab:doc nnproperty.net_numLayers">numLayers</a>, 
     * %    No = NET.<a href="matlab:doc nnproperty.net_numOutputs">numOutputs</a>
     * %    ID = NET.<a href="matlab:doc nnproperty.net_numInputDelays">numInputDelays</a>
     * %    LD = NET.<a href="matlab:doc nnproperty.net_numLayerDelays">numLayerDelays</a>
     * %    Ri = NET.<a href="matlab:doc nnproperty.net_inputs">inputs</a>{i}.<a 
     * href="matlab:doc nnproperty.input_size">size</a>
     * %    Si = NET.<a href="matlab:doc nnproperty.net_layers">layers</a>{i}.<a 
     * href="matlab:doc nnproperty.layer_size">size</a>
     * %    Ui = NET.<a href="matlab:doc nnproperty.net_outputs">outputs</a>{i}.<a 
     * href="matlab:doc nnproperty.output_size">size</a>
     * %
     * %  The columns of Xi, Xf, Ai, and Af are ordered from oldest delay
     * %  condition to most recent:
     * %    Xi{i,k} = input i at time ts=k-ID.
     * %    Xf{i,k} = input i at time ts=TS+k-ID.
     * %    Ai{i,k} = layer output i at time ts=k-LD.
     * %    Af{i,k} = layer output i at time ts=TS+k-LD.
     * %
     * %  [Y,Pf,Af] = SIM(net,{Q TS},Pi,Ai) is used for networks
     * %  which do not have an input, such as Hopfield networks
     * %  when cell array notation is used.
     * %
     * %  Here a static feedforward network is created, trained on some data, then
     * %  simulated using SIM and network notation.
     * %
     * %    [x,t] = <a href="matlab:doc simplefit_dataset">simplefit_dataset</a>;
     * %    net = <a href="matlab:doc feedforwardnet">feedforwardnet</a>(10);
     * %    net = <a href="matlab:doc train">train</a>(net,x,t);
     * %    y1 = <a href="matlab:doc sim">sim</a>(net,x)
     * %    y2 = net(x)
     * %
     * %  Here a dynamic NARX network is created, trained, and simulated on
     * %  time series data.
     * %
     * %   [X,T] = <a href="matlab:doc simplenarx_dataset">simplenarx_dataset</a>;
     * %   net = <a href="matlab:doc narxnet">narxnet</a>(1:2,1:2,10);
     * %   <a href="matlab:doc view">view</a>(net)
     * %   [Xs,Xi,Ai,Ts] = <a href="matlab:doc preparets">preparets</a>(net,X,{},T);
     * %   net = <a href="matlab:doc train">train</a>(net,Xs,Ts,Xi,Ai);
     * %   Y1 = <a href="matlab:doc sim">sim</a>(net,Xs,Xi,Ai)
     * %   Y2 = net(Xs,Xi,Ai)
     * %
     * %  See also INIT, REVERT, ADAPT, TRAIN
     * </pre>
     * </p>
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void sim2(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sSim2Signature);
    }

    /**
     * Provides the standard interface for calling the <code>sim2</code>
     * M-function with 2 input arguments.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %SIM Simulate a neural network.
     * %
     * %  SIM(NET,X) takes a network NET and inputs X and returns the outputs
     * %  Y generated by the network.  This syntax is equivalent to NET(X).
     * %
     * %  [Y,Xf,Af] = <a href="matlab:doc sim">sim</a>(NET,X,Xi,Ai) takes a dynamic 
     * network NET, inputs X,
     * %  and initial input and layer delays Xi and Ai.  It returns the outputs Y
     * %  and final input and layer delays states Xf and Af.
     * %
     * %  <a href="matlab:doc sim">sim</a> arguments can have two formats: matrices, for 
     * static
     * %  problems and networks with single inputs and outputs, and cell arrays
     * %  for multiple timesteps and networks with multiple inputs and outputs.
     * %
     * %  The matrix format is as follows:
     * %    X  - RxQ matrix
     * %    Y  - UxQ matrix.
     * %  Where:
     * %    Q  = number of samples
     * %    R  = number of elements in the network's input
     * %    U  = number of elements in the network's output
     * %
     * %  The cell array format is most general:
     * %    X  - NixTS cell array, each element X{i,ts} is an RixQ matrix.
     * %    Xi - NixID cell array, each element Xi{i,k} is an RixQ matrix.
     * %    Ai - NlxLD cell array, each element Ai{i,k} is an SixQ matrix.
     * %    Y  - NOxTS cell array, each element Y{i,ts} is a UixQ matrix.
     * %    Xf - NixID cell array, each element Xf{i,k} is an RixQ matrix.
     * %    Af - NlxLD cell array, each element Af{i,k} is an SixQ matrix.
     * %  Where:
     * %    TS = number of time steps
     * %    Ni = NET.<a href="matlab:doc nnproperty.net_numInputs">numInputs</a>
     * %    Nl = NET.<a href="matlab:doc nnproperty.net_numLayers">numLayers</a>, 
     * %    No = NET.<a href="matlab:doc nnproperty.net_numOutputs">numOutputs</a>
     * %    ID = NET.<a href="matlab:doc nnproperty.net_numInputDelays">numInputDelays</a>
     * %    LD = NET.<a href="matlab:doc nnproperty.net_numLayerDelays">numLayerDelays</a>
     * %    Ri = NET.<a href="matlab:doc nnproperty.net_inputs">inputs</a>{i}.<a 
     * href="matlab:doc nnproperty.input_size">size</a>
     * %    Si = NET.<a href="matlab:doc nnproperty.net_layers">layers</a>{i}.<a 
     * href="matlab:doc nnproperty.layer_size">size</a>
     * %    Ui = NET.<a href="matlab:doc nnproperty.net_outputs">outputs</a>{i}.<a 
     * href="matlab:doc nnproperty.output_size">size</a>
     * %
     * %  The columns of Xi, Xf, Ai, and Af are ordered from oldest delay
     * %  condition to most recent:
     * %    Xi{i,k} = input i at time ts=k-ID.
     * %    Xf{i,k} = input i at time ts=TS+k-ID.
     * %    Ai{i,k} = layer output i at time ts=k-LD.
     * %    Af{i,k} = layer output i at time ts=TS+k-LD.
     * %
     * %  [Y,Pf,Af] = SIM(net,{Q TS},Pi,Ai) is used for networks
     * %  which do not have an input, such as Hopfield networks
     * %  when cell array notation is used.
     * %
     * %  Here a static feedforward network is created, trained on some data, then
     * %  simulated using SIM and network notation.
     * %
     * %    [x,t] = <a href="matlab:doc simplefit_dataset">simplefit_dataset</a>;
     * %    net = <a href="matlab:doc feedforwardnet">feedforwardnet</a>(10);
     * %    net = <a href="matlab:doc train">train</a>(net,x,t);
     * %    y1 = <a href="matlab:doc sim">sim</a>(net,x)
     * %    y2 = net(x)
     * %
     * %  Here a dynamic NARX network is created, trained, and simulated on
     * %  time series data.
     * %
     * %   [X,T] = <a href="matlab:doc simplenarx_dataset">simplenarx_dataset</a>;
     * %   net = <a href="matlab:doc narxnet">narxnet</a>(1:2,1:2,10);
     * %   <a href="matlab:doc view">view</a>(net)
     * %   [Xs,Xi,Ai,Ts] = <a href="matlab:doc preparets">preparets</a>(net,X,{},T);
     * %   net = <a href="matlab:doc train">train</a>(net,Xs,Ts,Xi,Ai);
     * %   Y1 = <a href="matlab:doc sim">sim</a>(net,Xs,Xi,Ai)
     * %   Y2 = net(Xs,Xi,Ai)
     * %
     * %  See also INIT, REVERT, ADAPT, TRAIN
     * </pre>
     * </p>
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] sim2(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sSim2Signature), 
                    sSim2Signature);
        return lhs;
    }
    /**
     * Provides the interface for calling the <code>struct2</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %STRUCT Convert a neural network object to a structure.
     * %
     * %  <a href="matlab:doc struct">struct</a>(NET) take a network and returns its 
     * object information
     * %  as a structure.
     * </pre>
     * </p>
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void struct2(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sStruct2Signature);
    }

    /**
     * Provides the interface for calling the <code>struct2</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %STRUCT Convert a neural network object to a structure.
     * %
     * %  <a href="matlab:doc struct">struct</a>(NET) take a network and returns its 
     * object information
     * %  as a structure.
     * </pre>
     * </p>
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void struct2(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sStruct2Signature);
    }

    /**
     * Provides the standard interface for calling the <code>struct2</code>
     * M-function with 1 input argument.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %STRUCT Convert a neural network object to a structure.
     * %
     * %  <a href="matlab:doc struct">struct</a>(NET) take a network and returns its 
     * object information
     * %  as a structure.
     * </pre>
     * </p>
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] struct2(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sStruct2Signature), 
                    sStruct2Signature);
        return lhs;
    }
}

package pseudoCompiler;

import javax.naming.Context;
import javax.naming.InitialContext;

public class pseudoCompilerClient {
    public static void main(String[] args) throws Exception{
        String cmd[]={"javac"," Helloworld.java"};
        Context context = new InitialContext();
        String url="rmi://127.0.0.1:8001/pseudoCompiler";
        pseudoCompiler compiler = (pseudoCompiler) context.lookup(url);
        compiler.exec(cmd);
        System.out.println("build finished");

    }
}

package pseudoCompiler;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class pseudoCompilerImp extends UnicastRemoteObject implements pseudoCompiler {
    private Runtime rt;

    public pseudoCompilerImp() throws RemoteException{
        rt = Runtime.getRuntime();
    }

    @Override
    public void exec(String[] cmds) throws RemoteException {
        try{
            Process p =rt.exec(cmds,null,new File("D:\\IdeaProj\\JRMI\\src\\pseudoCompiler"));
            //all info will be shown on server side
            InputStream inputStream = p.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine())!=null){ //br读中文乱码
                System.out.println(line);
            }
            int exitVal = p.waitFor();
            System.out.println("Process exit value: "+exitVal);

        }catch (Exception e){

        }

    }

    public static void main(String[] args) throws Exception{
        pseudoCompilerImp compilerTest = new pseudoCompilerImp();
        String cmds[] = {"javac","Helloworld.java"};
        compilerTest.exec(cmds);
    }
}

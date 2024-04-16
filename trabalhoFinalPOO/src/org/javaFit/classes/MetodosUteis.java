package org.javaFit.classes;

import java.io.IOException;

public class MetodosUteis {
	
	//método para limpar console
	@SuppressWarnings("deprecation")
	public static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}

public static void limparTela() throws InterruptedException, IOException {
	String os = System.getProperty("os.name").toLowerCase();
    if (os.contains("win")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
    }
}

}

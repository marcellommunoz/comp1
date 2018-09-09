import java.io.FileWriter;
import java.io.PrintWriter;

class CodeGen{

	
	
	String geraCodigo (ArvoreSintatica arv) throws java.io.IOException
	{
		String textoArquivo = "";
		FileWriter arquivo = new FileWriter("saidaCodeGen.txt");
		PrintWriter gravarArquivo = new PrintWriter(arquivo);
		textoArquivo = geraCodigo2(arv) + "PRINT";
		gravarArquivo.print(textoArquivo);
		arquivo.close();
		return (textoArquivo);
	}
	String geraCodigo2 (ArvoreSintatica arv) throws java.io.IOException
	{
		if (arv instanceof Mult) {
			return (geraCodigo2(((Mult) arv).arg1) + 
				geraCodigo2(((Mult) arv).arg2) +
				"MULT\r\n");
		}

		if (arv instanceof Soma) {
			return (geraCodigo2(((Soma) arv).arg1) + 
				geraCodigo2(((Soma) arv).arg2) +
				"SUM\r\n");
		}
		if (arv instanceof Sub) {
			return (geraCodigo2(((Sub) arv).arg1) + 
				geraCodigo2(((Sub) arv).arg2) +
				"SUB\r\n");
		}
		if (arv instanceof Div) {
			return (geraCodigo2(((Div) arv).arg1) + 
				geraCodigo2(((Div) arv).arg2) +
				"DIV\r\n");
		}
		if (arv instanceof Num) {
			return ("PUSH "  + ((Num) arv).num + "\r\n");
		}

		return "";
	}
}

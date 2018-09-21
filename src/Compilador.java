class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			//AnaliseLexica al = new AnaliseLexica(args[0]);
			AnaliseLexica al = new AnaliseLexica("teste.txt");
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);
			/**
				Descomentar linha abaixo caso queira imprimir o código
			**/
			//System.out.println(codigo);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}

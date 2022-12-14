package parserJava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class ASTGenerator {
	
	public static String getFileContent(String filePath) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		StringBuilder sb = new StringBuilder();
		
		String line = br.readLine();
		while(line != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
			line = br.readLine();
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filePath = "InputFile.java";
		char[] fileContent = getFileContent(filePath).toCharArray();
		
		
		ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setResolveBindings(true);
		parser.setSource(fileContent);
		
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		cu.accept(new ASTVisitor() {
			
			public boolean visit(MethodDeclaration node) {
				SimpleName name = node.getName();
				int lineNumber = cu.getLineNumber(name.getStartPosition());
				System.out.println("Name:" + name.toString());
				System.out.println("Line:" + lineNumber);
				System.out.println("-------------------");
				return false;
			}
		});
	}
	
}

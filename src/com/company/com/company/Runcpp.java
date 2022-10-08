package com.company.com.company;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
//import org.antlr.v4.runtime.tree.gui.TreeViewer;
import org.antlr.v4.runtime.Token;

import java.io.FileInputStream;

public class Runcpp {

    public static void main(String[] args) throws Exception {
        // System.out.println("Parsing: " + args[0]);

        FileInputStream fis = new FileInputStream("C:\\Users\\Ajinkya\\Documents\\newz1_cpp\\student1120.c");
        ANTLRInputStream input = new ANTLRInputStream(fis);
        cpp lexer = new cpp(input);
        // CommonTokenStream tokens = new CommonTokenStream(lexer);


        //CParser parser = new CParser(input);

        Token token = lexer.nextToken();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CParser parser = new CParser(tokens);

        while (token.getType() != cpp.EOF) {
            System.out.println(token.getText());
            token = lexer.nextToken();
        }

      /*  ParserRuleContext ruleContext = parser.file();
        Trees.inspect(ruleContext, parser);*/


    }

}
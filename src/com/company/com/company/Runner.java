package com.company.com.company;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
//import org.antlr.v4.runtime.tree.gui.TreeViewer;
import org.antlr.v4.runtime.Token;

import java.io.FileInputStream;

public class Runner {

    public static void main(String[] args) throws Exception {
       // System.out.println("Parsing: " + args[0]);

        FileInputStream fis = new FileInputStream("F:\\Lakehead Subjects\\Thesis_summer_spring_fall2020\\new_z1\\student4959.c");
            ANTLRInputStream input = new ANTLRInputStream(fis);
        CLexer lexer = new CLexer(input);
       // CommonTokenStream tokens = new CommonTokenStream(lexer);


        //CParser parser = new CParser(input);

        Token token = lexer.nextToken();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

      //  CParser parser = new CParser(tokens);

        while (token.getType() != CLexer.EOF) {
            System.out.println(token.getText());
            token = lexer.nextToken();
        }

      //  ParserRuleContext ruleContext = parser.file();
        //Trees.inspect(ruleContext, parser);


    }

    }
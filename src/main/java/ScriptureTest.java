import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Clifton Craig on 4/25/16.
 */
public class ScriptureTest {
    public static void main(String[] args) {
        String program = asString(ScriptureTest.class.getResourceAsStream("MyScripture.verse"));
        ANTLRInputStream input = new ANTLRInputStream(program);
        // create a lexer that feeds off of input CharStream
        Scripture2Lexer lexer = new Scripture2Lexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        Scripture2Parser parser = new Scripture2Parser(tokens);

        ParseTree tree = parser.scipture(); // begin parsing at first rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree

    }

    private static String asString(InputStream inputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            for(String line = reader.readLine(); line!=null; line = reader.readLine()) {
                stringBuffer.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not convert to String", e);
        }
        return stringBuffer.toString();
    }
}

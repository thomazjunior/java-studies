import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FileProcessorTest {

    // ===========================
    // Paramètres pour le test
    // ===========================
    private String inputContent;
    private String expectedContent;
    private boolean shouldThrow;

    public FileProcessorTest(String inputContent, String expectedContent, boolean shouldThrow) {
        this.inputContent = inputContent;
        this.expectedContent = expectedContent;
        this.shouldThrow = shouldThrow;
    }

    @Parameterized.Parameters(name = "{index}: input='{0}' expect='{1}' throw={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"hello", "HELLO", false},
                {"JUnit", "JUNIT", false},
                {"error", null, true} // devrait générer une exception
        });
    }

    // ===========================
    // Rules
    // ===========================
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2); // chaque test < 2s

    @Rule
    public TestName testName = new TestName();

    // ===========================
    // Variables utilitaires
    // ===========================
    private File inputFile;
    private File outputFile;

    @Before
    public void setUp() throws IOException {
        System.out.println("Running test: " + testName.getMethodName());

        // Crée les fichiers temporaires
        inputFile = tempFolder.newFile("input.txt");
        outputFile = tempFolder.newFile("output.txt");

        // Écriture du contenu d'entrée
        Files.write(inputFile.toPath(), inputContent.getBytes());

        // Si on doit lancer une exception, configure ExpectedException
        if (shouldThrow) {
            exceptionRule.expect(IllegalArgumentException.class);
            exceptionRule.expectMessage("Contenu invalide");
        }
    }

    // ===========================
    // Test principal
    // ===========================
    @Test
    public void testFileProcessing() throws IOException {
        FileProcessor processor = new FileProcessor();

        processor.processFile(inputFile, outputFile);

        if (!shouldThrow) {
            // Vérifie le contenu du fichier de sortie
            String output = new String(Files.readAllBytes(outputFile.toPath()));
            assertEquals(expectedContent, output);
        }
    }

    // ===========================
    // Classe interne simulant la logique métier
    // ===========================
    static class FileProcessor {
        public void processFile(File input, File output) throws IOException {
            String content = new String(Files.readAllBytes(input.toPath()));
            if ("error".equals(content)) {
                throw new IllegalArgumentException("Contenu invalide");
            }
            String result = content.toUpperCase(); // traitement simple
            Files.write(output.toPath(), result.getBytes());
        }
    }
}

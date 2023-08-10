package com.hexadevlabs.gpt4allsample;

import com.hexadevlabs.gpt4all.LLModel;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // DIRECTION: Update the baseModelPath to the location of model files on your system.

        String modelFilePath = "ggml-gpt4all-j-v1.3-groovy.bin";

        String baseModelPath = "/Users/tomaszlelek/IntelliJ_workspace/gpt_experiments/";

        // Optionally in case override to location of shared libraries is necessary
        //LLModel.LIBRARY_SEARCH_PATH = "C:\\Users\\felix\\gpt4all\\lib\\";
        String prompt = "### Human:\nWhat is the meaning of life\n### Assistant:";

        // Debut output format. In case you need it.
        LLModel.OUTPUT_DEBUG=true;

        Path modelPath = Paths.get(baseModelPath + modelFilePath);

        try (LLModel model = new LLModel(modelPath)) {

            LLModel.GenerationConfig config = LLModel.config()
                    .withNPredict(4096).build();

            // String result = gptjModel.generate(prompt, config, true);
            String fullGeneration = model.generate(prompt, config, true);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

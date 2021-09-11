package com.br.uplag.similarity;

import java.util.List;
import java.util.Map;

public class OverlapSimilarity extends CodeSimilarity{
    public OverlapSimilarity(Map<String, Map<String, Double>> weightMap) {
        super(weightMap);
    }

    public OverlapSimilarity(Map<String, Map<String, Double>> weightMap, Integer threshold) {
        super(weightMap, threshold);
    }

    @Override
    public Double calculateDistance(List<Double> firstDocument, List<Double> secondDocument) {
        double euclidianFirstDocument = 0.0;
        double euclidianSecondDocument = 0.0;
        for (int i = 0; i < firstDocument.size(); i++) {
            euclidianFirstDocument += Math.pow(firstDocument.get(i), 2);
            euclidianSecondDocument += Math.pow(secondDocument.get(i), 2);
        }

        return Math.min(euclidianFirstDocument, euclidianSecondDocument);
    }

    @Override
    public Double calculateSimilarity(Double dotProduct, Double distance) {
        return dotProduct / distance;
    }
}

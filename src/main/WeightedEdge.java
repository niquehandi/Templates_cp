/*
TEMPLATE FOR COST/LENGTH EDGES FOR GRAPH
https://github.com/niquehandi/Templates_cp/

*/


import java.util.Map;
import java.util.Set;

public class WeightedEdge implements Comparable<WeightedEdge> {
  public final int startNode;
  public final int endNode;
  public final int weight;

  public WeightedEdge(int startNode, int endNode, int weight) {
    this.startNode = startNode;
    this.endNode = endNode;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "(" + startNode + ", " + endNode + ", w=" + weight + ")";
  }

  @Override
  public int compareTo(WeightedEdge otherEdge) {
    // Compare based on the start node
    int startComparison = this.startNode - otherEdge.startNode;

    // If the start nodes are equal, compare the end node
    if (startComparison == 0) {
      int endComparison = this.endNode - otherEdge.endNode;
      
      // If both the start and end nodes are equal, compare the weight
      if (endComparison == 0) {
        return this.weight - otherEdge.weight;
      } else {
        return endComparison;
      }
    } else {
      return startComparison;
    }
  }

  @Override
  public boolean equals(Object obj) {
    // Use the `instanceof` check to ensure that we are comparing a WeightedEdge object
    if (this == obj) return true; // Same object check
    if (!(obj instanceof WeightedEdge)) return false;

    WeightedEdge otherEdge = (WeightedEdge) obj;
    return this.startNode == otherEdge.startNode && this.endNode == otherEdge.endNode && this.weight == otherEdge.weight;
  }

  @Override
  public int hashCode() {
    // Generate a hash code based on the startNode, endNode, and weight
    int result = Integer.hashCode(startNode);
    result = 31 * result + Integer.hashCode(endNode);
    result = 31 * result + Integer.hashCode(weight);
    return result;
  }

  public static WeightedEdge createEdge(int u, int v, int w) {
    return new WeightedEdge(u, v, w);
  }
}

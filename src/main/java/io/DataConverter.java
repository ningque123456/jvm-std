package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataConverter {

    static Map<String, TreeNode> nodeMap = new HashMap<>();
    static TreeNode root = new TreeNode(-1, "中国");
    public static void main(String[] args) {
        String filename = "D:\\MyGitHub\\jvm-std\\src\\main\\java\\io\\area.txt"; // 文件名
        loadData(filename);
        // 示例调用
        System.out.println(isValid("上海市", "长宁区", null)); // 预期返回 true
        System.out.println(isValid("浙江省", "南京市", "滨江区")); // 预期返回 false


    }

    public static void loadData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                for (String part : parts) {
                    String[] idName = part.split(":");
                    int id = Integer.parseInt(idName[0]);
                    String name = idName[1];

                    if (!nodeMap.containsKey(name)) {
                        nodeMap.put(name, new TreeNode(id, name));
                    }
                }

                String[] first = parts[0].split(":");
                String[] second = parts[1].split(":");
//                int parentId = Integer.parseInt(first[0]);
//                int childId = Integer.parseInt(second[0]);
                String parentName = first[1];
                String childName = second[1];

                TreeNode parent = nodeMap.get(parentName);
                TreeNode child = nodeMap.get(childName);

                parent.addChild(child);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将省级节点添加到根节点
        for (TreeNode node : nodeMap.values()) {
            if ( nodeMap.values().stream().noneMatch(n -> n.children.contains(node))) {
                root.addChild(node);
            }
        }

        printTree(root, 0);
    }
    public static void printTree(TreeNode node, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.id + ":" + node.name);
        for (TreeNode child : node.children) {
            printTree(child, level + 1);
        }
    }

    public static boolean isValid(String lv1, String lv2, String lv3) {
        TreeNode level1Node = nodeMap.get(lv1);
        if (level1Node == null) {
            return false;
        }

        if (lv2 == null) {
            return true; // 如果第二级为空，只验证第一级
        }

        TreeNode level2Node = null;
        for (TreeNode child : level1Node.children) {
            if (child.name.equals(lv2)) {
                level2Node = child;
                break;
            }
        }
        if (level2Node == null) {
            return false;
        }

        if (lv3 == null) {
            return true; // 如果第三级为空，只验证到第二级
        }

        for (TreeNode child : level2Node.children) {
            if (child.name.equals(lv3)) {
                return true;
            }
        }
        return false;
    }
}
class TreeNode {
    int id;
    String name;
    List<TreeNode> children;

    TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
        this.children = new ArrayList<>();
    }

    void addChild(TreeNode child) {
        children.add(child);
        children.sort(Comparator.comparingInt(node -> node.id));
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
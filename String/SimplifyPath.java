import java.util.Stack;
// leetcode Problem No 71
/*Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.*/

class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        String s[] = path.split("/");
        for (int i = 0; i < s.length; i++) {
            if (!st.isEmpty() && s[i].equals(".."))
                st.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                st.push(s[i]);
        }

        if (st.isEmpty())
            return "/";
        while (!st.isEmpty()) {
            ans.insert(0, st.pop()).insert(0, "/");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String input = "/home/";
        System.out.println(simplifyPath(input));
    }
}
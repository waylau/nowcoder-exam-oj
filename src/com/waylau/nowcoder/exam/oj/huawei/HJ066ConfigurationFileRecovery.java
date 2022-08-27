/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 描述:有6条配置命令，它们执行的结果分别是：

命   令 |	执   行
---|---
reset	| reset what
reset board |	board fault
board add |	where to add
board delete	| no board at all
reboot backplane |	impossible
backplane abort	| install first
he he |	unknown command


注意：he he不是命令。

为了简化输入，方便用户，以“最短唯一匹配原则”匹配（注：需从首字母开始进行匹配）：

* 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，
* 执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
* 2、若只输入一字串，但匹配命令有两个关键字，则匹配失败。例如输入：reb，
* 可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
* 3、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果仍不唯一，匹配失败。
例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
* 4、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果唯一，匹配成功。
* 例如输入：bo a，确定是命令board add，匹配成功。
* 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。
* 例如输入：b addr，无法匹配到相应的命令，所以执行结果为：unknow command。
* 6、若匹配失败，打印“unknown command”

注意：有多组输入。

数据范围：数据组数： 1≤t≤800 ，字符串长度 1≤s≤20 

进阶：时间复杂度：O(n) ，空间复杂度：O(n) 

输入描述：
多行字符串，每行字符串一条命令

输出描述：
执行结果，每条命令输出一行



示例1

```
输入：
reset
reset board
board add
board delet
reboot backplane
backplane abort

输出：
reset what
board fault
where to add
no board at all
impossible
install first
```
 * @since 1.0.0 2022年8月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ066ConfigurationFileRecovery {

	// 两个字串的命令
	private static Map<String,String > TWO_WORDS_COMMANDS = new HashMap<>();

	
	public static void main(String[] args)
			throws IOException {
		// 输入
		// 输入
		Scanner br = new Scanner(System.in);
		
		TWO_WORDS_COMMANDS.put("reset board", "board fault");
		TWO_WORDS_COMMANDS.put("board add", "where to add");
		TWO_WORDS_COMMANDS.put("board delete", "no board at all");
		TWO_WORDS_COMMANDS.put("reboot backplane", "impossible");
		TWO_WORDS_COMMANDS.put("backplane abort", "install first");
		
		while(br.hasNext()) {
			String[] in = br.nextLine().split(" ");
			int inLength = in.length;
			String result = null;
			
			// 命令分为两种：一个字串组成的和两个字串组成的。分开处理
			// 输入的关键字只有一个的，只能去匹一个字串的命令；输入的关键字只有两个的，只能去匹两个字串的命令
			if (inLength == 1) {
				if(isMatch(in[0], "reset")) {
					result = "reset what";
				}
			} else if (inLength == 2) {
				int matchCount = 0;
				for (Entry<String, String> entry : TWO_WORDS_COMMANDS.entrySet() ) {
					String[] commandKeys = entry.getKey().split(" ");
					
					// 输入的关键字只有两个的，必须是这两个字串都匹配成功，且匹配结果唯一才算成功
					if (isMatch(in[0], commandKeys[0]) && isMatch(in[1], commandKeys[1])) {
						result = entry.getValue();
						matchCount ++;
					}
				}
				
				// 匹配结果需要唯一
				if (matchCount != 1) {
					result = "unknown command";
				}
				
			} else {
				result = "unknown command";
			}
			
			if (result == null) {
				result = "unknown command";
			}
			
			// 输出
			System.out.println(result);
		}

		// 关闭
		br.close();
	}

	
	private static boolean isMatch(String key,
			String command) {
		char[] keyCharArray = key.toCharArray();
		char[] commandCharArray = command.toCharArray();

		// 关键字匹配必须是所有字符都匹配，且与命令字符的位置也要一致。
		int len = key.length();
		for (int i = 0; i < len; i++) {
			if (keyCharArray[i] != commandCharArray[i]) {
				return false;
			}

		}

		return true;
	}
}

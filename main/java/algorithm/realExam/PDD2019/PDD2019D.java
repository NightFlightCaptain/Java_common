package algorithm.realExam.PDD2019;

import java.util.Scanner;

/**
 * 【回合制游戏】
 * <p>
 * 你在玩一个回合制角色扮演的游戏。现在你在准备一个策略，以便在最短的回合内击败敌方角色。在战斗开始时，敌人拥有HP格血量。当血量小于等于0时，敌人死去。一个缺乏经验的玩家可能简单地尝试每个回合都攻击。但是你知道辅助技能的重要性。
 * 在你的每个回合开始时你可以选择以下两个动作之一：聚力或者攻击。
 * 聚力会提高你下个回合攻击的伤害。
 * 攻击会对敌人造成一定量的伤害。如果你上个回合使用了聚力，那这次攻击会对敌人造成buffedAttack点伤害。否则，会造成normalAttack点伤害。
 * 给出血量HP和不同攻击的伤害，buffedAttack和normalAttack，返回你能杀死敌人的最小回合数。
 * <p>
 * 输入描述:
 * 第一行是一个数字HP
 * 第二行是一个数字normalAttack
 * 第三行是一个数字buffedAttack
 * 1 <= HP,buffedAttack,normalAttack <= 10^9
 * <p>
 * 输出描述:
 * 输出一个数字表示最小回合数
 * <p>
 * 输入例子1:
 * 13
 * 3
 * 5
 * <p>
 * 输出例子1:
 * 5
 *
 * @author: 小栗旬
 * @Date: 2019/11/25 21:08
 */
public class PDD2019D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hp = scanner.nextInt();
        int normalAttack = scanner.nextInt();
        int buffedAttack = scanner.nextInt();
        int count = 0;

        if (buffedAttack <= normalAttack * 2) {
            count = hp % normalAttack == 0 ? hp / normalAttack : hp / normalAttack + 1;
        } else {
            if (hp % buffedAttack == 0) {
                count = hp / buffedAttack * 2;
            } else if (hp % buffedAttack <= normalAttack) {
                count = hp / buffedAttack * 2 + 1;
            } else {
                count = hp / buffedAttack * 2 + 2;
            }
        }
        System.out.println(count);
    }
}

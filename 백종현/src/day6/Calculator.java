package day6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {// 계산기 구현
	// 버튼이 발생시키는 이벤트를 처리하기위한 ActionListener 인터페이스를 이용한 내부 클래스
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource(); //버튼 눌렀을때 버튼 객체 저장
            String buttonText = source.getText(); //누른 버튼 텍스트 저장
            String currentText = tField.getText(); // 쓰여지고 있는 식 저장
            String history = before.getText(); // 이전 게산 결과 저장
            String val = ""; 

            switch (buttonText) { //누른 버튼 기능 구현
                case "Backspace": // 문자열의 길이가 1보다 큰지 확인 후 ㅋ면 지우고 아니면 ""로
                    tField.setText(currentText.length() > 1 ? currentText.substring(0, currentText.length() - 1) : "");
                    break;

                case ".": //소수점 쓰여있는 식이 없으면 아무일도 안일어남
                    if (!currentText.isEmpty())
                        tField.setText(currentText + buttonText);
                    break;

                case "C": // 쓰고있는 식을 모두 초기화함
                    tField.setText("");
                    break;

                case "CE": // 쓰고있는 식과 이전 계산 결과 지움
                    before.setText("");
                    tField.setText("");
                    total = 0;
                    break;
                    
                case "R": // 이전 게산 결과 불러옴
                    tField.setText(history);
                    total = 0;
                    break;

                case "+":
                case "-":
                case "*":
                case "/":
                case "(":
                case ")": // 연산자 작성
                	tField.setText(currentText + " " + buttonText + " ");
                    break;

                case "=": // 후위식으로 변환후 게산 
                	val = action.toPostfix(currentText);
                	val = action.result(val);
                	before.setText(val);
                	tField.setText("");
                    break;

                default: // 숫자 쓰기
                    if ("0123456789".contains(buttonText)) // 버튼이 숫자일 경우 
                        tField.setText(currentText.equals("0") ? "" : currentText + buttonText);
                    break;
            }
        }
    }
    // 수업 사료 참고해 만듬
    static double total = 0;
    CalculatorAction action = new CalculatorAction(); // 내가만든 클래스
    private JPanel panel; // 전체창
    private JTextField tField; //계산 식이 쓰이는 부분
    private JTextField before; // 이전 게산 결과를 넣기 위한 부분
    private JButton[] buttons; //버튼 배열
    private String[] labels = {  // 버튼을 설정을 위한 배열
        "Backspace", " ", ".", "CE", "C",
        "7", "8", "9", "/", "R",
        "4", "5", "6", "*", " ",
        "1", "2", "3", "+", " ",
        "0", "(", ")", "-", "=",
    };
    
    public Calculator() { 
        tField = new JTextField(35); //
        panel = new JPanel();
        before = new JTextField(35);
        tField.setText(""); //처음에는 식 비움
        before.setText("0");  // 수정된 부분
        tField.setEnabled(true); //수정된 부분 키보드 입력 가능
        before.setEnabled(false);  // 수정된 부분 키보드 입력 불가능
       //행수는 동적 열 수는 5열 수평 수직 간격은 3
        panel.setLayout(new GridLayout(0, 5, 3, 3)); 
        buttons = new JButton[25];
        int index = 0;
        // for문을 이용해 버튼 설정
        for (int rows = 0; rows < 5; rows++) {
            for (int cols = 0; cols < 5; cols++) {
                buttons[index] = new JButton(labels[index]);
                if (cols >= 3) //4열 5열 글씨는 빨간색
                    buttons[index].setForeground(Color.red);
                else //1,2,3열 글씨는 파란색
                    buttons[index].setForeground(Color.blue);
                buttons[index].setBackground(Color.yellow); //노란배경 버튼
                buttons[index].addActionListener(new ButtonClickListener());
                panel.add(buttons[index]);
                index++;
            }
        }

        add(tField, BorderLayout.CENTER);
        add(before, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH); // 수정된 부분
        setVisible(true);
        pack();
    }

    public static void main(String args[]) {
        Calculator calculator = new Calculator();
    }
}

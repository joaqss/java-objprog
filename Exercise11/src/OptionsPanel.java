import javax.swing.*;
public class OptionsPanel {

    JPanel panel = new JPanel();
    JRadioButton rock, paper, scissors;
    ButtonGroup radioButtonGroup;

    public OptionsPanel() {

        rock = new JRadioButton("Rock"); rock.doClick();
        paper = new JRadioButton("Paper");
        scissors = new JRadioButton("Scissors");

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(rock);
        radioButtonGroup.add(paper);
        radioButtonGroup.add(scissors);

        panel.add(rock);
        panel.add(paper);
        panel.add(scissors);

    }

}

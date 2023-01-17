package com.example.demo15;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.security.auth.Subject;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;


public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    Label ma;
    @FXML
    Label ma1;
    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
    @FXML
    Button start;
    @FXML
    Button add;
    @FXML
    Button back;
    @FXML
    Button Next;
    @FXML
    Button remove;
    @FXML
    Button add1;
    @FXML
    Button add2;
    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button btn3;
    @FXML
    RadioButton haben_b;
    @FXML
    RadioButton help_b;
    @FXML
    RadioButton sein_b;
    @FXML
    RadioButton haben_b2;
    @FXML
    RadioButton sein_b2;
    @FXML
    TextField txtf3;
    @FXML
    TextField txtf4;
    @FXML
    TextField txtf5;
    @FXML
    Label label;
    @FXML
    Label page;
    @FXML
    ImageView im1;
    @FXML
    ImageView im2;
    @FXML
    ImageView im3;
    @FXML
    ImageView im4;
    @FXML
    TextField txtf1;
    @FXML
    TextField txtf2;
    @FXML
    Button remove1;
    @FXML
    Button remove2;
    @FXML
    Button change1;
    @FXML
    Button change2;
    @FXML
    Label l1;
    @FXML
    Label l2;
    @FXML
    Label l3;
    @FXML
    Label l4;
    @FXML
    Label l5;
    @FXML
    Label l6;
    @FXML
    Label l7;
    @FXML
    Label l8;
    @FXML
    Label l9;
    @FXML
    Label l10;

    @FXML
    TextField maximum;
    @FXML
    ChoiceBox<String> grouppick = new ChoiceBox<>();

    @FXML
    ListView <Words2>  words2ListView = new ListView<>();
    @FXML
    ListView <Words2>  words3ListView = new ListView<>();

    static ArrayList Haben = new ArrayList<>();
    static ArrayList Sein = new ArrayList<>();
    static ArrayList Subject = new ArrayList<>();
    static int Subjects1[] = new int[4];
    static ArrayList <Words1> word = new ArrayList<>();
    static ArrayList <Words1> wordseries = new ArrayList<>();

    static ArrayList <Groups> skupina = new ArrayList<>();
    static int Subjects[] = new int[4];
    static String Wrong_perfectum[] = new String[3];
    static int Help_line[] = new int[3];
    private Stage stage;
    private Scene scene;
    private Parent root;
    static int right_b = 0;
    static int r_i = 0;
    static int wrong = 0;
    static int type = 0;
    static int move = -1;
    static int left = 0;
    static int plus = 0;
    static int slo = 0;
    static int slo2 = 0;
    static int correct = 0;
    static int incorrect = 0;
    static int max = 5;
    static int group_number = 1;
    static int type_probability = 4;
    static int index = 0;
    static int index2 = 0;
    static  int starter1;
    static  int eee;
    static  int ott;
    static  int et;
    static  int eu;
    static  int ek;
    static  int ed;
    String h = "";
    String e = "";
    String j = "";
    public void switchtoScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
    public void switchtoScene2(ActionEvent event) throws IOException {
        starter1 = 0;
        ott = 0;
        try {
            ott = Integer.parseInt(maximum.getText());
        }catch(Exception e) {

            starter1 = 1;
        }




        if(grouppick.getSelectionModel().isEmpty()){
            starter1 = 1;
        }
        if(ott <= 0){
            starter1 = 1;
        }

        if(starter1 == 1){

        }else {

            index2 = grouppick.getSelectionModel().getSelectedIndex();
            if(ott > skupina.get(index2).count-1){
                max = skupina.get(index2).count;
            }else{
                max = ott;
            }
            group_number = skupina.get(index2).number;
            left = 0;
            move++;
            right_b = 0;
            incorrect = 0;
            button1.setVisible(true);
            button2.setVisible(true);
            button3.setVisible(true);
            button4.setVisible(true);
            label.setVisible(true);
            start.setVisible(false);
            Next.setVisible(false);
            button1.setDisable(false);
            button2.setDisable(false);
            button3.setDisable(false);
            button4.setDisable(false);
            im1.setVisible(false);
            im2.setVisible(false);
            im3.setVisible(false);
            im4.setVisible(false);
            back.setVisible(true);
            add.setVisible(false);
            l1.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            remove.setVisible(false);
            page.setVisible(true);
            maximum.setVisible(false);
            grouppick.setVisible(false);
            ma1.setVisible(false);
            ma.setVisible(false);
            ma.setText(null);
            if (move < max) {

                if (move == 0) {
                    wordseries.clear();
                    BufferedReader br = new BufferedReader(new FileReader("data.txt"));
                    String s = br.readLine();
                    if (s == null) {
                    } else {
                        try {

                            FileInputStream fileIn = new FileInputStream("data.txt");
                            ObjectInputStream in = new ObjectInputStream(fileIn);
                            wordseries = (ArrayList<Words1>) in.readObject();
                            in.close();
                            fileIn.close();
                        } catch (IOException i) {
                            i.printStackTrace();
                            return;
                        } catch (ClassNotFoundException c) {
                            c.printStackTrace();
                            return;
                        }
                    }
                    br.close();

                    word.clear();
                    eee = 0;
                    Collections.sort(wordseries, new GroupComparator());
                    for (int i = wordseries.size()-1; i >= 0 ; i--) {
                        if (wordseries.get(i).group <= group_number) {
                            if(eee < max) {
                                word.add(wordseries.get(i));
                                eee++;
                            }

                        }
                    }
                    Collections.shuffle(word);

                }
                setting();
                Rightbutton();
                SubjectSet();
                PerfectumtSet();

                String output = word.get(move).infinitiv.substring(0, 1).toUpperCase() + word.get(move).infinitiv.substring(1);
                label.setText(output + "en");
                page.setText((move + 1) + " / " + max);
                for (int g = 0; g < 1; g++) {

                }
                if (right_b == 1) {
                    if (word.get(move).verb == 1) {
                        for (int g = 0; g < 8; g++) {
                            if (g < 2) {
                                if (Subjects1[0] - 1 == g) {
                                    h = (String) Haben.get(g);
                                }
                            }
                            if (g >= 2 && g <= 4) {
                                if (Subjects1[0] - 1 == g) {
                                    h = (String) Haben.get(2);
                                }
                            }
                            if (g > 4) {
                                if (Subjects1[0] - 1 == g) {
                                    h = (String) Haben.get(g - 2);
                                }
                            }
                        }
                    } else {
                        for (int g = 0; g < 8; g++) {
                            if (g < 2) {
                                if (Subjects1[0] - 1 == g) {
                                    h = (String) Sein.get(g);
                                }
                            }
                            if (g >= 2 && g <= 4) {
                                if (Subjects1[0] - 1 == g) {
                                    h = (String) Sein.get(2);
                                }
                            }
                            if (g > 4) {
                                if (Subjects1[0] - 1 == g) {
                                    h = (String) Sein.get(g - 2);
                                }
                            }
                        }
                    }
                    button1.setText((String) Subject.get(Subjects1[0] - 1) + " " + h + " " + word.get(move).gerundium.toLowerCase());
                    h = "";
                    e = "";
                } else {
                    Random randomGenerator2 = new Random();
                    wrong = randomGenerator2.nextInt(3) + 1;
                    type = randomGenerator2.nextInt(type_probability) + 1;
                    if (wrong == 3) {
                        wrong = randomGenerator2.nextInt(6);
                        if (type == type_probability) {
                            h = (String) Sein.get(wrong);
                            if (Subjects1[0] == 8 && wrong == 2 || Subjects1[0] == 2 && wrong == 1 || wrong == 2 && Subjects1[0] >= 3 && Subjects1[0] <= 5 || Subjects1[0] > 6 && wrong == Subjects1[0] - 3 || Subjects1[0] == 8 && wrong == 3 || Subjects1[0] == 6 && wrong == 5/*|| Subjects1[0] == 7 && wrong == 3*/) {
                                h = (String) Sein.get(wrong - 1);
                            }
                            if (Subjects1[0] == 1 && wrong == 0) {
                                h = (String) Sein.get(wrong + 1);
                            }
                            e = word.get(move).gerundium.toLowerCase();

                        } else {
                            h = (String) Haben.get(wrong);
                            if (Subjects1[0] == 8 && wrong == 2 || Subjects1[0] == 2 && wrong == 1 || wrong == 2 && Subjects1[0] >= 3 && Subjects1[0] <= 5 || Subjects1[0] > 6 && wrong == Subjects1[0] - 3 || Subjects1[0] == 8 && wrong == 3 || Subjects1[0] == 6 && wrong == 5) {
                                h = (String) Haben.get(wrong - 1);
                            }
                            if (Subjects1[0] == 1 && wrong == 0) {
                                h = (String) Haben.get(wrong + 1);
                            }
                            e = word.get(move).gerundium.toLowerCase();


                        }
                    } else {

                        if (word.get(move).preposition == 1 && Wrong_perfectum[Help_line[left]] != null) {
                            e = "ge" + Wrong_perfectum[Help_line[left]];
                        } else if (word.get(move).preposition == 0 && Wrong_perfectum[Help_line[left]] != null) {
                            e = Wrong_perfectum[Help_line[left]];
                        } else if (word.get(move).preposition == 1 && Wrong_perfectum[Help_line[left]] == null) {
                            plus = randomGenerator2.nextInt(2);
                            if (plus == 1) {
                                e = word.get(move).infinitiv.toLowerCase() + "en";
                            } else {
                                e = word.get(move).infinitiv.toLowerCase() + "t";
                            }
                        } else if (word.get(move).preposition == 0 && Wrong_perfectum[Help_line[left]] == null) {
                            e = "ge" + word.get(move).infinitiv + "en";
                            plus = randomGenerator2.nextInt(2);
                            if (plus == 1) {
                                e = "ge" + word.get(move).infinitiv.toLowerCase() + "en";
                            } else {
                                e = "ge" + word.get(move).infinitiv.toLowerCase() + "t";
                            }
                        }
                        left++;
                        if (type < type_probability) {
                            for (int g = 0; g < 8; g++) {
                                if (g < 2) {
                                    if (Subjects1[0] - 1 == g) {
                                        h = (String) Haben.get(g);
                                    }
                                }
                                if (g >= 2 && g <= 4) {
                                    if (Subjects1[0] - 1 == g) {
                                        h = (String) Haben.get(2);
                                    }
                                }
                                if (g > 4) {
                                    if (Subjects1[0] - 1 == g) {
                                        h = (String) Haben.get(g - 2);
                                    }
                                }
                            }
                        } else {
                            for (int g = 0; g < 8; g++) {
                                if (g < 2) {
                                    if (Subjects1[0] - 1 == g) {
                                        h = (String) Sein.get(g);
                                    }
                                }
                                if (g >= 2 && g <= 4) {
                                    if (Subjects1[0] - 1 == g) {
                                        h = (String) Sein.get(2);
                                    }
                                }
                                if (g > 4) {
                                    if (Subjects1[0] - 1 == g) {
                                        h = (String) Sein.get(g - 2);
                                    }
                                }
                            }
                        }
                    }
                    button1.setText((String) Subject.get(Subjects1[0] - 1) + " " + h + " " + e);
                    h = "";
                    e = "";
                }


                if (right_b == 2) {
                    if (word.get(move).verb == 1) {
                        for (int g = 0; g < 8; g++) {
                            if (g < 2) {
                                if (Subjects1[1] - 1 == g) {
                                    h = (String) Haben.get(g);
                                }
                            }
                            if (g >= 2 && g <= 4) {
                                if (Subjects1[1] - 1 == g) {
                                    h = (String) Haben.get(2);
                                }
                            }
                            if (g > 4) {
                                if (Subjects1[1] - 1 == g) {
                                    h = (String) Haben.get(g - 2);
                                }
                            }
                        }
                    } else {
                        for (int g = 0; g < 8; g++) {
                            if (g < 2) {
                                if (Subjects1[1] - 1 == g) {
                                    h = (String) Sein.get(g);
                                }
                            }
                            if (g >= 2 && g <= 4) {
                                if (Subjects1[1] - 1 == g) {
                                    h = (String) Sein.get(2);
                                }
                            }
                            if (g > 4) {
                                if (Subjects1[1] - 1 == g) {
                                    h = (String) Sein.get(g - 2);
                                }
                            }
                        }
                    }
                    button2.setText((String) Subject.get(Subjects1[1] - 1) + " " + h + " " + word.get(move).gerundium.toLowerCase());
                    h = "";
                    e = "";
                } else {
                    Random randomGenerator2 = new Random();
                    wrong = randomGenerator2.nextInt(3) + 1;
                    type = randomGenerator2.nextInt(type_probability) + 1;

                    if (wrong == 3) {
                        wrong = randomGenerator2.nextInt(6);
                        if (type == type_probability) {
                            h = (String) Sein.get(wrong);
                            if (Subjects1[1] == 8 && wrong == 2 || Subjects1[1] == 2 && wrong == 1 || wrong == 2 && Subjects1[1] >= 3 && Subjects1[1] <= 5 || Subjects1[1] > 6 && wrong == Subjects1[1] - 3 || Subjects1[1] == 8 && wrong == 3 || Subjects1[1] == 6 && wrong == 5) {
                                h = (String) Sein.get(wrong - 1);
                            }
                            if (Subjects1[1] == 1 && wrong == 0) {
                                h = (String) Sein.get(wrong + 1);
                            }
                            e = word.get(move).gerundium.toLowerCase();

                        } else {
                            h = (String) Haben.get(wrong);
                            if (Subjects1[1] == 8 && wrong == 2 || Subjects1[1] == 2 && wrong == 1 || wrong == 2 && Subjects1[1] >= 3 && Subjects1[1] <= 5 || Subjects1[1] > 6 && wrong == Subjects1[1] - 3 || Subjects1[1] == 8 && wrong == 3 || Subjects1[1] == 6 && wrong == 5) {
                                h = (String) Haben.get(wrong - 1);
                            }
                            if (Subjects1[1] == 1 && wrong == 0) {
                                h = (String) Haben.get(wrong + 1);
                            }
                            e = word.get(move).gerundium.toLowerCase();

                        }
                    } else {

                        if (word.get(move).preposition == 1 && Wrong_perfectum[Help_line[left]] != null) {
                            e = "ge" + Wrong_perfectum[Help_line[left]];
                        } else if (word.get(move).preposition == 0 && Wrong_perfectum[Help_line[left]] != null) {
                            e = Wrong_perfectum[Help_line[left]];
                        } else if (word.get(move).preposition == 1 && Wrong_perfectum[Help_line[left]] == null) {
                            e = word.get(move).infinitiv + "en";
                            plus = randomGenerator2.nextInt(2);
                            if (plus == 1) {
                                e = word.get(move).infinitiv.toLowerCase() + "en";
                            } else {
                                e = word.get(move).infinitiv.toLowerCase() + "t";
                            }
                        } else if (word.get(move).preposition == 0 && Wrong_perfectum[Help_line[left]] == null) {
                            e = "ge" + word.get(move).infinitiv + "en";
                            plus = randomGenerator2.nextInt(2);
                            if (plus == 1) {
                                e = "ge" + word.get(move).infinitiv.toLowerCase() + "en";
                            } else {
                                e = "ge" + word.get(move).infinitiv.toLowerCase() + "t";
                            }
                        }
                        left++;
                        if (type < type_probability) {
                            for (int g = 0; g < 8; g++) {
                                if (g < 2) {
                                    if (Subjects1[1] - 1 == g) {
                                        h = (String) Haben.get(g);
                                    }
                                }
                                if (g >= 2 && g <= 4) {
                                    if (Subjects1[1] - 1 == g) {
                                        h = (String) Haben.get(2);
                                    }
                                }
                                if (g > 4) {
                                    if (Subjects1[1] - 1 == g) {
                                        h = (String) Haben.get(g - 2);
                                    }
                                }
                            }
                        } else {
                            for (int g = 0; g < 8; g++) {
                                if (g < 2) {
                                    if (Subjects1[1] - 1 == g) {
                                        h = (String) Sein.get(g);
                                    }
                                }
                                if (g >= 2 && g <= 4) {
                                    if (Subjects1[1] - 1 == g) {
                                        h = (String) Sein.get(2);
                                    }
                                }
                                if (g > 4) {
                                    if (Subjects1[1] - 1 == g) {
                                        h = (String) Sein.get(g - 2);
                                    }
                                }
                            }
                        }
                    }
                    button2.setText((String) Subject.get(Subjects1[1] - 1) + " " + h + " " + e);
                    h = "";
                    e = "";
                }


                if (right_b == 3) {
                    if (word.get(move).verb == 1) {
                        for (int g = 0; g < 8; g++) {
                            if (g < 2) {
                                if (Subjects1[2] - 1 == g) {
                                    h = (String) Haben.get(g);
                                }
                            }
                            if (g >= 2 && g <= 4) {
                                if (Subjects1[2] - 1 == g) {
                                    h = (String) Haben.get(2);
                                }
                            }
                            if (g > 4) {
                                if (Subjects1[2] - 1 == g) {
                                    h = (String) Haben.get(g - 2);
                                }
                            }
                        }
                    } else {
                        for (int g = 0; g < 8; g++) {
                            if (g < 2) {
                                if (Subjects1[2] - 1 == g) {
                                    h = (String) Sein.get(g);
                                }
                            }
                            if (g >= 2 && g <= 4) {
                                if (Subjects1[2] - 1 == g) {
                                    h = (String) Sein.get(2);
                                }
                            }
                            if (g > 4) {
                                if (Subjects1[2] - 1 == g) {
                                    h = (String) Sein.get(g - 2);
                                }
                            }
                        }
                    }
                    button3.setText((String) Subject.get(Subjects1[2] - 1) + " " + h + " " + word.get(move).gerundium.toLowerCase());
                    h = "";
                    e = "";
                } else {
                    Random randomGenerator2 = new Random();
                    wrong = randomGenerator2.nextInt(3) + 1;
                    type = randomGenerator2.nextInt(type_probability) + 1;
                    if (wrong == 3) {
                        wrong = randomGenerator2.nextInt(6);
                        if (type == type_probability) {
                            h = (String) Sein.get(wrong);
                            if ((Subjects1[2] == 8 && wrong == 2) || (Subjects1[2] == 2 && wrong == 1) || (wrong == 2 && Subjects1[2] >= 3 && Subjects1[2] <= 5) || (Subjects1[2] > 6 && wrong == Subjects1[2] - 3) || Subjects1[2] == 8 && wrong == 3 || Subjects1[2] == 6 && wrong == 5) {
                                h = (String) Sein.get(wrong - 1);
                            }
                            if (Subjects1[2] == 1 && wrong == 0) {
                                h = (String) Sein.get(wrong + 1);
                            }

                            e = word.get(move).gerundium.toLowerCase();

                        } else {
                            h = (String) Haben.get(wrong);
                            if (Subjects1[2] == 8 && wrong == 2 || Subjects1[2] == 2 && wrong == 1 || wrong == 2 && Subjects1[2] >= 3 && Subjects1[2] <= 5 || Subjects1[2] > 6 && wrong == Subjects1[2] - 3 || Subjects1[2] == 8 && wrong == 3 || Subjects1[2] == 6 && wrong == 5) {
                                h = (String) Haben.get(wrong - 1);
                            }
                            if (Subjects1[2] == 1 && wrong == 0) {
                                h = (String) Haben.get(wrong + 1);
                            }

                            e = word.get(move).gerundium.toLowerCase();

                        }
                    } else {

                        if (word.get(move).preposition == 1 && Wrong_perfectum[Help_line[left]] != null) {
                            e = "ge" + Wrong_perfectum[Help_line[left]];
                        } else if (word.get(move).preposition == 0 && Wrong_perfectum[Help_line[left]] != null) {
                            e = Wrong_perfectum[Help_line[left]];
                        } else if (word.get(move).preposition == 1 && Wrong_perfectum[Help_line[left]] == null) {
                            e = word.get(move).infinitiv + "en";
                            plus = randomGenerator2.nextInt(2);
                            if (plus == 1) {
                                e = word.get(move).infinitiv.toLowerCase() + "en";
                            } else {
                                e = word.get(move).infinitiv.toLowerCase() + "t";
                            }
                        } else if (word.get(move).preposition == 0 && Wrong_perfectum[Help_line[left]] == null) {
                            e = "ge" + word.get(move).infinitiv + "en";
                            plus = randomGenerator2.nextInt(2);
                            if (plus == 1) {
                                e = "ge" + word.get(move).infinitiv.toLowerCase() + "en";
                            } else {
                                e = "ge" + word.get(move).infinitiv.toLowerCase() + "t";
                            }
                        }
                        left++;
                        if (type < type_probability) {
                            for (int g = 0; g < 8; g++) {
                                if (g < 2) {
                                    if (Subjects1[2] - 1 == g) {
                                        h = (String) Haben.get(g);
                                    }
                                }
                                if (g >= 2 && g <= 4) {
                                    if (Subjects1[2] - 1 == g) {
                                        h = (String) Haben.get(2);
                                    }
                                }
                                if (g > 4) {
                                    if (Subjects1[2] - 1 == g) {
                                        h = (String) Haben.get(g - 2);
                                    }
                                }
                            }
                        } else {
                            for (int g = 0; g < 8; g++) {
                                if (g < 2) {
                                    if (Subjects1[2] - 1 == g) {
                                        h = (String) Sein.get(g);
                                    }
                                }
                                if (g >= 2 && g <= 4) {
                                    if (Subjects1[2] - 1 == g) {
                                        h = (String) Sein.get(2);
                                    }
                                }
                                if (g > 4) {
                                    if (Subjects1[2] - 1 == g) {
                                        h = (String) Sein.get(g - 2);
                                    }
                                }
                            }
                        }
                    }
                    button3.setText((String) Subject.get(Subjects1[2] - 1) + " " + h + " " + e);
                    h = "";
                    e = "";
                }


                if (right_b == 4) {
                    if (word.get(move).verb == 1) {
                        for (int g = 0; g < 8; g++) {
                            if (g < 2) {
                                if (Subjects1[3] - 1 == g) {
                                    h = (String) Haben.get(g);
                                }
                            }
                            if (g >= 2 && g <= 4) {
                                if (Subjects1[3] - 1 == g) {
                                    h = (String) Haben.get(2);
                                }
                            }
                            if (g > 4) {
                                if (Subjects1[3] - 1 == g) {
                                    h = (String) Haben.get(g - 2);
                                }
                            }
                        }
                    } else {
                        for (int g = 0; g < 8; g++) {
                            if (g < 2) {
                                if (Subjects1[3] - 1 == g) {
                                    h = (String) Sein.get(g);
                                }
                            }
                            if (g >= 2 && g <= 4) {
                                if (Subjects1[3] - 1 == g) {
                                    h = (String) Sein.get(2);
                                }
                            }
                            if (g > 4) {
                                if (Subjects1[3] - 1 == g) {
                                    h = (String) Sein.get(g - 2);
                                }
                            }
                        }
                    }
                    button4.setText((String) Subject.get(Subjects1[3] - 1) + " " + h + " " + word.get(move).gerundium.toLowerCase());
                    h = "";
                    e = "";
                } else {
                    Random randomGenerator2 = new Random();
                    wrong = randomGenerator2.nextInt(3) + 1;
                    type = randomGenerator2.nextInt(type_probability) + 1;
                    if (wrong == 3) {
                        wrong = randomGenerator2.nextInt(6);
                        if (type == type_probability) {
                            h = (String) Sein.get(wrong);
                            if (Subjects1[3] == 8 && wrong == 2 || Subjects1[3] == 2 && wrong == 1 || wrong == 2 && Subjects1[3] >= 3 && Subjects1[3] <= 5 || Subjects1[3] > 6 && wrong == Subjects1[3] - 3 || Subjects1[3] == 8 && wrong == 3 || Subjects1[3] == 6 && wrong == 5) {
                                h = (String) Sein.get(wrong - 1);
                            }
                            if (Subjects1[3] == 1 && wrong == 0) {
                                h = (String) Sein.get(wrong + 1);
                            }

                            e = word.get(move).gerundium.toLowerCase();

                        } else {
                            h = (String) Haben.get(wrong);
                            if (Subjects1[3] == 8 && wrong == 2 || Subjects1[3] == 2 && wrong == 1 || wrong == 2 && Subjects1[3] >= 3 && Subjects1[3] <= 5 || Subjects1[3] > 6 && wrong == Subjects1[3] - 3 || Subjects1[3] == 8 && wrong == 3 || Subjects1[3] == 6 && wrong == 5) {
                                h = (String) Haben.get(wrong - 1);
                            }
                            if (Subjects1[3] == 1 && wrong == 0) {
                                h = (String) Haben.get(wrong + 1);
                            }

                            e = word.get(move).gerundium.toLowerCase();

                        }
                    } else {
                        if (word.get(move).preposition == 1 && Wrong_perfectum[Help_line[left]] != null) {
                            e = "ge" + Wrong_perfectum[Help_line[left]];
                        } else if (word.get(move).preposition == 0 && Wrong_perfectum[Help_line[left]] != null) {
                            e = Wrong_perfectum[Help_line[left]];
                        } else if (word.get(move).preposition == 1 && Wrong_perfectum[Help_line[left]] == null) {
                            e = word.get(move).infinitiv + "en";
                            plus = randomGenerator2.nextInt(2);
                            if (plus == 1) {
                                e = word.get(move).infinitiv.toLowerCase() + "en";
                            } else {
                                e = word.get(move).infinitiv.toLowerCase() + "t";
                            }
                        } else if (word.get(move).preposition == 0 && Wrong_perfectum[Help_line[left]] == null) {
                            e = "ge" + word.get(move).infinitiv + "en";
                            plus = randomGenerator2.nextInt(2);
                            if (plus == 1) {
                                e = "ge" + word.get(move).infinitiv.toLowerCase() + "en";
                            } else {
                                e = "ge" + word.get(move).infinitiv.toLowerCase() + "t";
                            }
                        }
                        left++;
                        if (type < type_probability) {
                            for (int g = 0; g < 8; g++) {
                                if (g < 2) {
                                    if (Subjects1[3] - 1 == g) {
                                        h = (String) Haben.get(g);
                                    }
                                }
                                if (g >= 2 && g <= 4) {
                                    if (Subjects1[3] - 1 == g) {
                                        h = (String) Haben.get(2);
                                    }
                                }
                                if (g > 4) {
                                    if (Subjects1[3] - 1 == g) {
                                        h = (String) Haben.get(g - 2);
                                    }
                                }
                            }
                        } else {
                            for (int g = 0; g < 8; g++) {
                                if (g < 2) {
                                    if (Subjects1[3] - 1 == g) {
                                        h = (String) Sein.get(g);
                                    }
                                }
                                if (g >= 2 && g <= 4) {
                                    if (Subjects1[3] - 1 == g) {
                                        h = (String) Sein.get(2);
                                    }
                                }
                                if (g > 4) {
                                    if (Subjects1[3] - 1 == g) {
                                        h = (String) Sein.get(g - 2);
                                    }
                                }
                            }
                        }
                    }
                    button4.setText((String) Subject.get(Subjects1[3] - 1) + " " + h + " " + e);
                    h = "";
                    e = "";
                }
            } else {
                button1.setVisible(false);
                button2.setVisible(false);
                button3.setVisible(false);
                button4.setVisible(false);
                label.setText("Správně " + " " + correct + "/" + max);
                page.setVisible(false);
            }
        }

    }
    static void setting(){

        Haben.add("habe");
        Haben.add("hast");
        Haben.add("hat");
        Haben.add("haben");
        Haben.add("habt");
        Haben.add("haben");

        Sein.add("bin");
        Sein.add("bist");
        Sein.add("ist");
        Sein.add("sein");
        Sein.add("seid");
        Sein.add("sein");

        Subject.add("Ich");
        Subject.add("Du");
        Subject.add("Er");
        Subject.add("Sie");
        Subject.add("Es");
        Subject.add("Wir");
        Subject.add("Ihr");
        Subject.add("Sie");

    }
    static void Rightbutton(){
        Random randomGenerator=new Random();
        right_b = randomGenerator.nextInt(4) + 1 ;


    }
    static void SubjectSet() {
        int Numbers[] = {1, 2, 3, 4, 5, 6, 7,8};

        int help[] = new int[10];
        Random generator = new Random();
        int coda = 0;
        int coda2 = -1;
        for (int o = 0; o < 4; o++) {
            int randomNumber2 = generator.nextInt(Numbers.length);
            coda2++;
            Subjects[coda2] = Numbers[randomNumber2];
            Subjects1[coda2] = Subjects[coda2];
            Numbers[randomNumber2] = Numbers[randomNumber2] * -1;
            for (int y = 0; y < Numbers.length; y++) {
                help[y] = Numbers[y];
            }
            Numbers = new int[Numbers.length - 1];
            for (int y = 0; y < Numbers.length; y++) {
                if (help[y] >= 0) {
                    Numbers[y] = help[y + coda];
                } else {
                    coda++;
                    Numbers[y] = help[y + coda];

                }
            }
            coda = 0;

        }

        coda = 0;

    }
    static void PerfectumtSet() {
        String pp = word.get(move).gerundium;
        String p = pp.substring(pp.length() - 1);

        if(p.equals("t")){
            Wrong_perfectum[0]= word.get(move).infinitiv.toLowerCase() + "en";
            Wrong_perfectum[1]= null ;
            Wrong_perfectum[2]= word.get(move).infinitiv.toLowerCase() + "en";
        }else if(p.equals("n")){
            Wrong_perfectum[0] = word.get(move).infinitiv.toLowerCase() + "t";
            Wrong_perfectum[1] = null;
            Wrong_perfectum[2] = word.get(move).infinitiv.toLowerCase() + "t";

        }else{
            Wrong_perfectum[0] = word.get(move).infinitiv.toLowerCase() + "en";
            Wrong_perfectum[1] = word.get(move).infinitiv.toLowerCase() + "t";
            Wrong_perfectum[2] = null;
        }
        for(int i = 0; i <3; i++) {
            int counter = 0;
            Random generator = new Random();
            int oy = generator.nextInt(3)+1;
            for(int e = 0; e <i; e++){
                if(Help_line[i] == oy){
                    counter =1;
                }
            }
            if(counter ==1){
                i--;
            }else{
                Help_line[i] = oy-1;

            }
        }
    }
    public void b1(ActionEvent event) throws IOException {
        im1.setVisible(true);
        if(right_b == 1){
            Next.setVisible(true);
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
            im1.setStyle("-fx-image:url(https://images.freeimages.com/fic/images/icons/1008/quiet/256/yes.png?ref=findicons);");

            if(incorrect == 0 ){

                correct++;
            }
        }else{
            incorrect = 1;
            im1.setStyle("-fx-image:url(https://www.pngmart.com/files/17/Wrong-PNG-Image.png);");

        }

    }
    public void b2(ActionEvent event) throws IOException {
        im2.setVisible(true);
        if(right_b == 2){
            Next.setVisible(true);
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
            im2.setStyle("-fx-image:url(https://images.freeimages.com/fic/images/icons/1008/quiet/256/yes.png?ref=findicons);");

            if(incorrect == 0 ){
                correct++;
            }
        }else{
            incorrect = 1;
            im2.setStyle("-fx-image:url(https://www.pngmart.com/files/17/Wrong-PNG-Image.png);");
        }

    }
    public void b3(ActionEvent event) throws IOException {
        im3.setVisible(true);
        if(right_b == 3){
            Next.setVisible(true);
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
            im3.setStyle("-fx-image:url(https://images.freeimages.com/fic/images/icons/1008/quiet/256/yes.png?ref=findicons);");
            if(incorrect == 0 ){
                correct++;
            }
        }else{
            incorrect = 1;
            im3.setStyle("-fx-image:url(https://www.pngmart.com/files/17/Wrong-PNG-Image.png);");
        }

    }
    public void b4(ActionEvent event) throws IOException {
        im4.setVisible(true);
        if(right_b == 4){
            Next.setVisible(true);
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
            im4.setStyle("-fx-image:url(https://images.freeimages.com/fic/images/icons/1008/quiet/256/yes.png?ref=findicons);");
            if(incorrect == 0 ){
                correct++;
            }
        }else{
            incorrect = 1;
            im4.setStyle("-fx-image:url(https://www.pngmart.com/files/17/Wrong-PNG-Image.png);");
        }

    }
    public void addonAction(ActionEvent event) throws IOException {
        ma1.setVisible(false);
        ma.setVisible(false);
        ma.setText(null);
        txtf1.setVisible(true);
        txtf2.setVisible(true);
        add1.setVisible(true);
        start.setVisible(false);
        sein_b.setVisible(true);
        haben_b.setVisible(true);
        remove.setVisible(false);
        add.setVisible(false);
        back.setVisible(true);
        words2ListView.setVisible(true);
        page.setVisible(false);
        txtf3.setVisible(true);
        txtf4.setVisible(true);
        txtf5.setVisible(true);
        haben_b2.setVisible(true);
        sein_b2.setVisible(true);
        add2.setVisible(true);
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        maximum.setVisible(false);
        grouppick.setVisible(false);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(true);
        l5.setVisible(true);
        l6.setVisible(true);
        l7.setVisible(true);
        l8.setVisible(true);
        l9.setVisible(true);
        l10.setVisible(true);
        wordseries.clear();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String s = br.readLine();
        if (s == null) {
        } else {
            try {

                FileInputStream fileIn = new FileInputStream("data.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                wordseries = (ArrayList<Words1>) in.readObject();

                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return;
            }
        }
        br.close();

        for(int y = 0; y < wordseries.size();y ++) {
            words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv,         ", wordseries.get(y).gerundium, " -perfektum,         ", wordseries.get(y).group," -skupina"));
        }



    }
    public void removeonAction(ActionEvent event) throws IOException {
        ma1.setVisible(false);
        ma.setVisible(false);
        ma.setText(null);
        txtf1.setVisible(true);
        txtf2.setVisible(true);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        start.setVisible(false);
        sein_b.setVisible(true);
        haben_b.setVisible(true);
        remove.setVisible(false);
        add.setVisible(false);
        back.setVisible(true);
        words2ListView.setVisible(true);
        page.setVisible(false);
        txtf3.setVisible(true);
        txtf4.setVisible(true);
        txtf5.setVisible(true);
        haben_b2.setVisible(true);
        sein_b2.setVisible(true);
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        sein_b.setDisable(true);
        haben_b.setDisable(true);
        sein_b2.setDisable(true);
        haben_b2.setDisable(true);
        txtf1.setDisable(true);
        txtf2.setDisable(true);
        txtf3.setDisable(true);
        txtf4.setDisable(true);
        txtf5.setDisable(true);
        change1.setVisible(true);
        change2.setVisible(true);
        remove1.setVisible(true);
        remove2.setVisible(true);
        remove1.setDisable(true);
        remove2.setDisable(true);
        change1.setDisable(true);
        change2.setDisable(true);
        maximum.setVisible(false);
        grouppick.setVisible(false);
        l4.setVisible(true);
        l5.setVisible(true);
        l6.setVisible(true);
        l7.setVisible(true);
        l8.setVisible(true);
        l9.setVisible(true);
        l10.setVisible(true);

        r_i = 1;

        wordseries.clear();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String s = br.readLine();
        if (s == null) {
        } else {
            try {

                FileInputStream fileIn = new FileInputStream("data.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                wordseries = (ArrayList<Words1>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return;
            }
        }
        br.close();
        for(int y = 0; y < wordseries.size();y ++) {
            words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv,         ", wordseries.get(y).gerundium, " -perfektum,         ", wordseries.get(y).group," -skupina"));
        }


    }
    public void backonAction(ActionEvent event) throws IOException {
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        label.setVisible(false);
        start.setVisible(true);
        add.setVisible(true);
        remove.setVisible(true);
        back.setVisible(false);
        txtf1.setVisible(false);
        txtf2.setVisible(false);
        add1.setVisible(false);
        sein_b.setVisible(false);
        haben_b.setVisible(false);
        words2ListView.setVisible(false);
        txtf3.setVisible(false);
        txtf4.setVisible(false);
        txtf5.setVisible(false);
        haben_b2.setVisible(false);
        sein_b2.setVisible(false);
        add2.setVisible(false);
        page.setVisible(false);
        im1.setVisible(false);
        im2.setVisible(false);
        im3.setVisible(false);
        im4.setVisible(false);
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(false);
        l5.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        l8.setVisible(false);
        l9.setVisible(false);
        l10.setVisible(false);
        ma1.setVisible(true);
        ma.setVisible(true);
        ma.setText(null);
        words3ListView.setVisible(false);
        words2ListView.getItems().clear();
        words3ListView.getItems().clear();
        move = -1;
        left = 0;
        right_b = 0;
        slo = 0;
        slo2 = 0;
        txtf1.setText(null);
        txtf2.setText(null);
        txtf3.setText(null);
        txtf4.setText(null);
        txtf5.setText(null);
        haben_b.setSelected(false);
        haben_b2.setSelected(false);
        sein_b.setSelected(false);
        sein_b2.setSelected(false);
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);
        Next.setVisible(false);
        sein_b.setDisable(false);
        haben_b.setDisable(false);
        sein_b2.setDisable(false);
        haben_b2.setDisable(false);
        txtf1.setDisable(false);
        txtf2.setDisable(false);
        txtf3.setDisable(false);
        txtf4.setDisable(false);
        txtf5.setDisable(false);
        change1.setVisible(false);
        change2.setVisible(false);
        remove1.setVisible(false);
        remove2.setVisible(false);
        remove1.setDisable(true);
        remove2.setDisable(true);
        change1.setDisable(true);
        change2.setDisable(true);
        maximum.setVisible(true);
        grouppick.setVisible(true);




        wordseries.clear();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String s = br.readLine();
        if (s == null) {
        } else {
            try {

                FileInputStream fileIn = new FileInputStream("data.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                wordseries = (ArrayList<Words1>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return;
            }
        }

        br.close();


        skupina.clear();
        grouppick.getItems().clear();
        Collections.sort(wordseries, new GroupComparator());
        int u = 1;
        int oq = 0;
        int ik = 1;
        ArrayList<String> str = new ArrayList<>();
        for(int i = 0; i < wordseries.size(); i++){
            if(i == 0){
                skupina.add(new Groups(wordseries.get(i).group,u,ik));
                String h = String.valueOf(wordseries.get(i).group);
                str.add(h);
                u++;
                ik++;

            } else if(skupina.get(oq).number == wordseries.get(i).group) {
                skupina.remove(oq);
                skupina.add(new Groups(wordseries.get(i).group,u,ik));
                u++;
                ik++;
            }else{
                ik = 1;
                oq ++;
                skupina.add(new Groups(wordseries.get(i).group,u,ik));
                String h = String.valueOf(wordseries.get(i).group);
                str.add(h);
                u++;
                ik++;
            }
        }
        grouppick.getItems().addAll(str);
        if (grouppick.getItems().size() > 0) {
            grouppick.setOnAction(this::getNumber);
        }

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wordseries);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }






        maximum.setText(null);
        incorrect = 0;
        correct = 0;
        r_i = 0;
        index = 0;
    }
    public void seinonAction(ActionEvent event) throws IOException {
        if(sein_b.isSelected()){
            slo  = 2;
        }
    }
    public void habenonAction(ActionEvent event) throws IOException {
        if(haben_b.isSelected()){
            slo  = 1;
        }
    }
    public void add1onAction(ActionEvent event) throws IOException {
        int check = 0;
        String txt1 = (String) txtf1.getText();
        String txt2 = (String) txtf2.getText();
        et = 0;
        try {
            et = Integer.parseInt(txt2);
        }catch(Exception e) {
            check = 1;

        }
        if(txt1 == null){
            check = 1;
        }else{
            if(txt1.length() < 3){
                check = 1;
            }
        }
        if(slo == 0){
            check = 1;
        }
        if(txt2 == null){
            check = 1;
        }
        if(check == 1){
        }else{
            String ot = txt1.substring(0,txt1.length() - 2);
            int ww = 0;
            if(slo == 1){
                ww = 1;
            }else{
                ww= 0;
            }

            String hh = "ge" + ot + "t";

            wordseries.clear();
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String s = br.readLine();
            if (s == null) {
            } else {
                try {

                    FileInputStream fileIn = new FileInputStream("data.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    wordseries = (ArrayList<Words1>) in.readObject();
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                    return;
                }
            }

            br.close();

            wordseries.add(new Words1(ww,1,ot,hh,et,0));

            skupina.clear();
            grouppick.getItems().clear();
            Collections.sort(wordseries, new GroupComparator());
            int u = 1;
            int oq = 0;
            int ik = 1;
            ArrayList<String> str = new ArrayList<>();
            for(int i = 0; i < wordseries.size(); i++){
                if(i == 0){
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    u++;
                    ik++;

                } else if(skupina.get(oq).number == wordseries.get(i).group) {
                    skupina.remove(oq);
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    u++;
                    ik++;
                }else{
                    oq ++;
                    ik = 1;
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    u++;
                    ik++;
                }
            }
            grouppick.getItems().addAll(str);
            if (grouppick.getItems().size() > 0) {
                grouppick.setOnAction(this::getNumber);
            }
            words2ListView.getItems().clear();
            for(int y = 0; y < wordseries.size();y ++) {
                words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv        ", wordseries.get(y).gerundium, " -perfektum        ", wordseries.get(y).group," -skupina"));
            }
            try {
                FileOutputStream fileOut =
                        new FileOutputStream("data.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(wordseries);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
            slo =0;
            help_b.setSelected(true);
            txtf1.setText(null);
            txtf2.setText(null);
        }
        check = 0;
    }


    public void sein2onAction(ActionEvent event) throws IOException {
        if(sein_b2.isSelected()){
            slo2  = 2;
        }
    }
    public void haben2onAction(ActionEvent event) throws IOException {
        if(haben_b2.isSelected()){
            slo2  = 1;
        }
    }
    public void add2onAction(ActionEvent event) throws IOException {
        int check = 0;
        String txt1 = (String) txtf3.getText();
        String txt2 = (String) txtf4.getText();
        String txt3 = (String) txtf5.getText();
        if(txt1 == null){
            check = 1;
        }else{
            if(txt1.length() < 3){
                check = 1;
            }
        }
        if(slo2 == 0){
            check = 1;
        }
        if(txt2 == null){
            check = 1;

        }else{
            if(txt2.length() < 3){
                check = 1;
            }
        }
        if(txt3 == null){
            check = 1;
        }
        try {
            eu = Integer.parseInt(txt3);
        }catch(Exception e) {
            check = 1;

        }
        if(check == 1){
        }else {
            String ot = txt1.substring(0, txt1.length() - 2);
            int ww = 0;
            if (slo2 == 1) {
                ww = 1;
            } else {
                ww = 0;
            }
            String ok = txt2.substring(0, 2);
            int jj = 0;
            if(ok.equals("ge")){
                jj = 1;
            }

            String hh = "ge" + ot + "t";
            wordseries.clear();
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String s = br.readLine();
            if (s == null) {
            } else {
                try {

                    FileInputStream fileIn = new FileInputStream("data.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    wordseries = (ArrayList<Words1>) in.readObject();
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                    return;
                }
            }

            br.close();


            wordseries.add(new Words1(ww,jj,ot,txt2,eu,1));

            skupina.clear();
            grouppick.getItems().clear();
            Collections.sort(wordseries, new GroupComparator());
            int u = 1;
            int oq = 0;
            int ik = 1;
            ArrayList<String> str = new ArrayList<>();
            for(int i = 0; i < wordseries.size(); i++){
                if(i == 0){
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    u++;
                    ik++;

                } else if(skupina.get(oq).number == wordseries.get(i).group) {
                    skupina.remove(oq);
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    u++;
                    ik++;
                }else{
                    ik = 1;
                    oq ++;
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    u++;
                    ik++;
                }
            }
            grouppick.getItems().addAll(str);
            if (grouppick.getItems().size() > 0) {
                grouppick.setOnAction(this::getNumber);
            }
            words2ListView.getItems().clear();
            for(int y = 0; y < wordseries.size();y ++) {
                words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv        ", wordseries.get(y).gerundium, " -perfektum        ", wordseries.get(y).group," -skupina"));
            }

            try {
                FileOutputStream fileOut =
                        new FileOutputStream("data.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(wordseries);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }



            haben_b2.setSelected(false);
            sein_b2.setSelected(false);
            txtf3.setText(null);
            txtf4.setText(null);
            txtf5.setText(null);
            slo2 = 0;
        }
        check = 0;
    }

    public void btn1onAction(ActionEvent event) throws IOException {
        wordseries.clear();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String s = br.readLine();
        if (s == null) {
        } else {
            try {

                FileInputStream fileIn = new FileInputStream("data.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                wordseries = (ArrayList<Words1>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return;
            }
        }

        br.close();
        Collections.sort(wordseries, new InfinitivComparator());
        words2ListView.getItems().clear();
        for(int y = 0; y < wordseries.size();y ++) {
            words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv,         ", wordseries.get(y).gerundium, " -perfektum,         ", wordseries.get(y).group," -skupina"));
        }

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wordseries);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        if(r_i ==1){
            txtf1.setText(null);
            txtf2.setText(null);

            txtf3.setText(null);
            txtf4.setText(null);
            txtf5.setText(null);
            haben_b.setSelected(false);
            haben_b2.setSelected(false);
            sein_b.setSelected(false);
            sein_b2.setSelected(false);
            remove1.setDisable(true);
            remove2.setDisable(true);
            change1.setDisable(true);
            change2.setDisable(true);
            sein_b.setDisable(true);
            haben_b.setDisable(true);
            sein_b2.setDisable(true);
            haben_b2.setDisable(true);
            txtf1.setDisable(true);
            txtf2.setDisable(true);
            txtf3.setDisable(true);
            txtf4.setDisable(true);
            txtf5.setDisable(true);

            slo = 0;
            slo2 = 0;
        }
    }
    public void btn2onAction(ActionEvent event) throws IOException {
        wordseries.clear();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String s = br.readLine();
        if (s == null) {
        } else {
            try {

                FileInputStream fileIn = new FileInputStream("data.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                wordseries = (ArrayList<Words1>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return;
            }
        }

        br.close();
        Collections.sort(wordseries, new PerfectumComparator());
        words2ListView.getItems().clear();
        for(int y = 0; y < wordseries.size();y ++) {
            words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv,         ", wordseries.get(y).gerundium, " -perfektum,         ", wordseries.get(y).group," -skupina"));
        }

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wordseries);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        if(r_i ==1){
            txtf1.setText(null);
            txtf2.setText(null);

            txtf3.setText(null);
            txtf4.setText(null);
            txtf5.setText(null);
            haben_b.setSelected(false);
            haben_b2.setSelected(false);
            sein_b.setSelected(false);
            sein_b2.setSelected(false);
            remove1.setDisable(true);
            remove2.setDisable(true);
            change1.setDisable(true);
            change2.setDisable(true);
            sein_b.setDisable(true);
            haben_b.setDisable(true);
            sein_b2.setDisable(true);
            haben_b2.setDisable(true);
            txtf1.setDisable(true);
            txtf2.setDisable(true);
            txtf3.setDisable(true);
            txtf4.setDisable(true);
            txtf5.setDisable(true);
            slo = 0;
            slo2 = 0;
        }
    }
    public void btn3onAction(ActionEvent event) throws IOException {
        wordseries.clear();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String s = br.readLine();
        if (s == null) {
        } else {
            try {

                FileInputStream fileIn = new FileInputStream("data.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                wordseries = (ArrayList<Words1>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return;
            }
        }

        br.close();
        Collections.sort(wordseries, new GroupComparator());
        words2ListView.getItems().clear();
        for(int y = 0; y < wordseries.size();y ++) {
            words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv,         ", wordseries.get(y).gerundium, " -perfektum,         ", wordseries.get(y).group," -skupina"));
        }

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wordseries);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        if(r_i ==1){
            txtf1.setText(null);
            txtf2.setText(null);

            txtf3.setText(null);
            txtf4.setText(null);
            txtf5.setText(null);
            haben_b.setSelected(false);
            haben_b2.setSelected(false);
            sein_b.setSelected(false);
            sein_b2.setSelected(false);
            remove1.setDisable(true);
            remove2.setDisable(true);
            change1.setDisable(true);
            change2.setDisable(true);
            sein_b.setDisable(true);
            haben_b.setDisable(true);
            sein_b2.setDisable(true);
            haben_b2.setDisable(true);
            txtf1.setDisable(true);
            txtf2.setDisable(true);
            txtf3.setDisable(true);
            txtf4.setDisable(true);
            txtf5.setDisable(true);
            slo = 0;
            slo2 = 0;
        }

    }


    public void remove1onAction(ActionEvent event) throws IOException {
        wordseries.clear();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String s = br.readLine();
        if (s == null) {
        } else {
            try {

                FileInputStream fileIn = new FileInputStream("data.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                wordseries = (ArrayList<Words1>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return;
            }
        }
        br.close();
        wordseries.remove(index);
        skupina.clear();
        grouppick.getItems().clear();
        Collections.sort(wordseries, new GroupComparator());
        int u = 1;
        int oq = 0;
        int ik = 1;
        ArrayList<String> str = new ArrayList<>();
        for(int i = 0; i < wordseries.size(); i++){
            if(i == 0){
                skupina.add(new Groups(wordseries.get(i).group,u,ik));
                String h = String.valueOf(wordseries.get(i).group);
                str.add(h);
                u++;
                ik++;

            } else if(skupina.get(oq).number == wordseries.get(i).group) {
                skupina.remove(oq);
                skupina.add(new Groups(wordseries.get(i).group,u,ik));
                u++;
                ik++;
            }else{
                ik = 1;
                oq ++;
                skupina.add(new Groups(wordseries.get(i).group,u,ik));
                String h = String.valueOf(wordseries.get(i).group);
                str.add(h);
                u++;
                ik++;
            }
        }
        grouppick.getItems().addAll(str);
        if (grouppick.getItems().size() > 0) {
            grouppick.setOnAction(this::getNumber);
        }
        words2ListView.getItems().clear();
        for(int y = 0; y < wordseries.size();y ++) {
            words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv,         ", wordseries.get(y).gerundium, " -perfektum,         ", wordseries.get(y).group," -skupina"));
        }
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wordseries);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        txtf1.setDisable(true);
        txtf2.setDisable(true);
        sein_b.setDisable(true);
        haben_b.setDisable(true);
        remove1.setDisable(true);
        change1.setDisable(true);
        haben_b.setSelected(false);
        sein_b.setSelected(false);
        txtf1.setText(null);
        txtf2.setText(null);
    }
    public void remove2onAction(ActionEvent event) throws IOException {
        wordseries.clear();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String s = br.readLine();
        if (s == null) {
        } else {
            try {

                FileInputStream fileIn = new FileInputStream("data.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                wordseries = (ArrayList<Words1>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return;
            }
        }
        br.close();
        wordseries.remove(index);
        skupina.clear();
        grouppick.getItems().clear();
        Collections.sort(wordseries, new GroupComparator());
        int u = 1;
        int oq = 0;
        int ik = 1;
        ArrayList<String> str = new ArrayList<>();
        for(int i = 0; i < wordseries.size(); i++){
            if(i == 0){
                skupina.add(new Groups(wordseries.get(i).group,u,ik));
                String h = String.valueOf(wordseries.get(i).group);
                str.add(h);
                u++;
                ik++;

            } else if(skupina.get(oq).number == wordseries.get(i).group) {
                skupina.remove(oq);
                skupina.add(new Groups(wordseries.get(i).group,u,ik));
                u++;
                ik++;
            }else{
                ik = 1;
                oq ++;
                skupina.add(new Groups(wordseries.get(i).group,u,ik));
                String h = String.valueOf(wordseries.get(i).group);
                str.add(h);
                u++;
                ik++;
            }
        }
        grouppick.getItems().addAll(str);
        if (grouppick.getItems().size() > 0) {
            grouppick.setOnAction(this::getNumber);
        }
        words2ListView.getItems().clear();
        for(int y = 0; y < wordseries.size();y ++) {
            words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv,         ", wordseries.get(y).gerundium, " -perfektum,         ", wordseries.get(y).group," -skupina"));
        }
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wordseries);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        txtf3.setDisable(true);
        txtf4.setDisable(true);
        txtf5.setDisable(true);
        sein_b2.setDisable(true);
        haben_b2.setDisable(true);
        remove2.setDisable(true);
        change2.setDisable(true);
        haben_b2.setSelected(false);
        sein_b2.setSelected(false);
        txtf3.setText(null);
        txtf4.setText(null);
        txtf5.setText(null);
    }
    public void change1onAction(ActionEvent event) throws IOException {
        int check = 0;
        ek = 0;
        String txt1 = (String) txtf1.getText();
        String txt2 = (String) txtf2.getText();
        if(txt1 == null){

            check = 1;
        }else{
            if(txt1.length() < 3){
                check = 1;
            }
        }
        if(slo == 0){
            check = 1;
        }
        if(txt2 == null){
            check = 1;
        }
        try {
            ek = Integer.parseInt(txt2);
        }catch(Exception e) {
            check = 1;

        }
        if(check == 1){
        }else {
            String ot = txt1.substring(0,txt1.length() - 2);
            int ww = 0;
            if(slo == 1){
                ww = 1;
            }else{
                ww= 0;
            }
            String hh = "ge" + ot + "t";

            wordseries.clear();
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String s = br.readLine();
            if (s == null) {
            } else {
                try {

                    FileInputStream fileIn = new FileInputStream("data.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    wordseries = (ArrayList<Words1>) in.readObject();
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                    return;
                }
            }
            br.close();
            wordseries.remove(index);
            wordseries.add(new Words1(ww,1,ot,hh,ek,0));
            skupina.clear();
            grouppick.getItems().clear();
            Collections.sort(wordseries, new GroupComparator());
            int u = 1;
            int oq = 0;
            int ik = 1;
            ArrayList<String> str = new ArrayList<>();
            for(int i = 0; i < wordseries.size(); i++){
                if(i == 0){
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    u++;
                    ik++;

                } else if(skupina.get(oq).number == wordseries.get(i).group) {
                    skupina.remove(oq);
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    u++;
                    ik++;
                }else{
                    ik= 1;
                    oq ++;
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    u++;
                    ik++;
                }
            }
            grouppick.getItems().addAll(str);
            if (grouppick.getItems().size() > 0) {
                grouppick.setOnAction(this::getNumber);
            }
            words2ListView.getItems().clear();
            for (int y = 0; y < wordseries.size(); y++) {
                words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv,         ", wordseries.get(y).gerundium, " -perfektum,         ", wordseries.get(y).group, " -skupina"));
            }
            try {
                FileOutputStream fileOut =
                        new FileOutputStream("data.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(wordseries);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
            txtf1.setDisable(true);
            txtf2.setDisable(true);
            sein_b.setDisable(true);
            haben_b.setDisable(true);
            remove1.setDisable(true);
            change1.setDisable(true);
            haben_b.setSelected(false);
            sein_b.setSelected(false);
            txtf1.setText(null);
            txtf2.setText(null);
            slo = 0;
        }
    }
    public void change2onAction(ActionEvent event) throws IOException {
        int check = 0;
        ed = 0;
        String txt1 = (String) txtf3.getText();
        String txt2 = (String) txtf4.getText();
        String txt3 = (String) txtf5.getText();
        if(txt1 == null){
            check = 1;
        }else{
            if(txt1.length() < 3){
                check = 1;
            }
        }
        if(slo2 == 0){
            check = 1;
        }
        if(txt2 == null){
            check = 1;
        }else{
            if(txt2.length() < 3){
                check = 1;
            }
        }
        if(txt3 == null){
            check = 1;
        }
        try {
            ed = Integer.parseInt(txt3);
        }catch(Exception e) {
            check = 1;

        }
        if(check == 1){
        }else {
            String ot = txt1.substring(0, txt1.length() - 2);
            int ww = 0;
            if (slo2 == 1) {
                ww = 1;
            } else {
                ww = 0;
            }
            String ok = txt2.substring(0, 2);
            int jj = 0;
            if(ok.equals("ge")){
                jj = 1;
            }

            String hh = "ge" + ot + "t";
            wordseries.clear();
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String s = br.readLine();
            if (s == null) {
            } else {
                try {

                    FileInputStream fileIn = new FileInputStream("data.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    wordseries = (ArrayList<Words1>) in.readObject();
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                    return;
                }
            }

            br.close();

            wordseries.remove(index);
            wordseries.add(new Words1(ww,jj,ot,txt2,ed,1));
            skupina.clear();
            grouppick.getItems().clear();
            Collections.sort(wordseries, new GroupComparator());
            int u = 1;
            int oq = 0;
            int ik = 1;
            ArrayList<String> str = new ArrayList<>();
            for(int i = 0; i < wordseries.size(); i++){
                if(i == 0){
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    u++;
                    ik++;

                } else if(skupina.get(oq).number == wordseries.get(i).group) {
                    skupina.remove(oq);
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    u++;
                    ik++;
                }else{
                    ik = 1;
                    oq ++;
                    skupina.add(new Groups(wordseries.get(i).group,u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    u++;
                    ik++;
                }
            }
            grouppick.getItems().addAll(str);
            if (grouppick.getItems().size() > 0) {
                grouppick.setOnAction(this::getNumber);
            }
            words2ListView.getItems().clear();
            for(int y = 0; y < wordseries.size();y ++) {
                words2ListView.getItems().add(new Words2(wordseries.get(y).infinitiv, "en - infinitiv        ", wordseries.get(y).gerundium, " -perfektum        ", wordseries.get(y).group, " -skupina"));
            }
            try {
                FileOutputStream fileOut =
                        new FileOutputStream("data.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(wordseries);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }



            haben_b2.setSelected(false);
            sein_b2.setSelected(false);
            txtf3.setText(null);
            txtf4.setText(null);
            txtf5.setText(null);
            slo2 = 0;
        }
        check = 0;
    }
    public void displayonAction(MouseEvent event) throws IOException {
        if (r_i == 1) {
            index = words2ListView.getSelectionModel().getSelectedIndex()/*, )*/;
            int o1 = wordseries.get(index).verb;
            int o2 = wordseries.get(index).preposition;
            String o3 = wordseries.get(index).infinitiv;
            String o4 = wordseries.get(index).gerundium;
            int o5 = wordseries.get(index).group;
            int o6 = wordseries.get(index).irregular;
            if(o6 == 1){
                txtf3.setText(o3+"en");
                txtf4.setText(o4);
                txtf5.setText(String.valueOf(o5));
                if(o1 == 1){
                    haben_b2.setSelected(true);
                    slo2 = 1;
                }else{
                    sein_b2.setSelected(true);
                    slo2 = 2;
                }
                txtf1.setDisable(true);
                txtf2.setDisable(true);
                sein_b.setDisable(true);
                haben_b.setDisable(true);
                remove1.setDisable(true);
                change1.setDisable(true);
                txtf3.setDisable(false);
                txtf4.setDisable(false);
                txtf5.setDisable(false);
                sein_b2.setDisable(false);
                haben_b2.setDisable(false);
                remove2.setDisable(false);
                change2.setDisable(false);
                haben_b.setSelected(false);
                sein_b.setSelected(false);
                txtf1.setText(null);
                txtf2.setText(null);
            }else{
                txtf1.setText(o3+"en");
                txtf2.setText(String.valueOf(o5));
                if(o1 == 1){
                    haben_b.setSelected(true);
                    slo = 1;
                }else{
                    sein_b.setSelected(true);
                    slo = 2;
                }
                txtf1.setDisable(false);
                txtf2.setDisable(false);
                sein_b.setDisable(false);
                haben_b.setDisable(false);
                remove1.setDisable(false);
                change1.setDisable(false);
                txtf3.setDisable(true);
                txtf4.setDisable(true);
                txtf5.setDisable(true);
                sein_b2.setDisable(true);
                haben_b2.setDisable(true);
                remove2.setDisable(true);
                change2.setDisable(true);
                haben_b2.setSelected(false);
                sein_b2.setSelected(false);
                txtf3.setText(null);
                txtf4.setText(null);
                txtf5.setText(null);
            }

        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wordseries.clear();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data.txt"));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        if (s == null) {
        } else {
            try {

                FileInputStream fileIn = new FileInputStream("data.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                wordseries = (ArrayList<Words1>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return;
            }
        }
        try {
            br.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        skupina.clear();
        Collections.sort(wordseries, new GroupComparator());
        int u = 1;
        int oq = 0;
        int ik = 1;
        ArrayList<String> str = new ArrayList<>();
        if(wordseries.size() >1 ) {
            for (int i = 0; i < wordseries.size(); i++) {
                if (i == 0) {
                    skupina.add(new Groups(wordseries.get(i).group, u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    u++;
                    ik++;

                } else if (skupina.get(oq).number == wordseries.get(i).group) {
                    skupina.remove(oq);
                    skupina.add(new Groups(wordseries.get(i).group, u,ik));
                    u++;
                    ik++;
                } else {
                    ik = 1;
                    oq++;
                    skupina.add(new Groups(wordseries.get(i).group, u,ik));
                    String h = String.valueOf(wordseries.get(i).group);
                    str.add(h);
                    ik++;
                    u++;
                }
            }
            grouppick.getItems().addAll(str);
            if (grouppick.getItems().size() > 0) {
                grouppick.setOnAction(this::getNumber);
            }

        }

    }
    public void getNumber(ActionEvent event) {
        if (grouppick.getItems().size() > 0) {
            String wq = grouppick.getValue();
            int ww = Integer.parseInt(wq);
            if (grouppick.getItems().size() > 0) {
                for (int i = 0; i < grouppick.getItems().size(); i++) {
                    for (int t = 0; t < skupina.size(); t++) {
                        if (skupina.get(t).number == ww) {
                            maximum.setText(String.valueOf(skupina.get(t).count));
                            ma.setText(String.valueOf(skupina.get(t).amount));
                        }
                    }
                }
            }
        }
    }

}
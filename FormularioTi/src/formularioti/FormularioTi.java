
package formularioti;

    import java.awt.BorderLayout;
    import java.awt.Color;
    import java.awt.Container;
    import java.awt.Font;
    import java.awt.GridBagLayout;
    import java.awt.GridLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.ItemEvent;
    import java.awt.event.ItemListener;
    import javax.swing.ImageIcon;
    import javax.swing.JButton;
    import javax.swing.JCheckBox;
    import javax.swing.JComboBox;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JTextField;
    import javax.swing.SwingConstants;

public class FormularioTi extends JFrame implements ItemListener,ActionListener {
        JButton btEnviar,btLimpar;
        JCheckBox hard,soft,rede,outro;
        JTextField solic,cidade,email,tDescricao;
        JComboBox<String> comboEstado;
        JLabel titulo,logolabel,lSolicitante,
                lCidade,lEmail,lEstado,lHard,
                lSoft,lRede,lOutro,tipoServ,
                lDescricao;
        boolean a,b,c,d;
        
        public FormularioTi(){
            
            super("Formulário de solicitação");
            
//---------------Container principal, border de fundo---------------------------            

            Container cMain = getContentPane();
            cMain.setLayout(new BorderLayout());
            
            
                //--container logo/titulo---------------------------------------
                Container cLogo = new JPanel();
                cLogo.setLayout(new BorderLayout()); 

                    ImageIcon logo = new ImageIcon(getClass().getResource("fotos/logo.png"));            
                    JLabel logolabel = new JLabel();
                    logolabel.setIcon(logo);
                    cLogo.add(BorderLayout.WEST,logolabel);

                    Font fonte = new Font("sansserif",Font.BOLD,22);
                    titulo = new JLabel("Formulário de Solicitação de serviços de t.i.",SwingConstants.CENTER);
                    titulo.setFont(fonte);
                    cLogo.add(BorderLayout.CENTER, titulo);
                    
                    
                //--container central-caixas------------------------------------
                    Container cCentro =new JPanel();
                    cCentro.setLayout(new BorderLayout());
                        //--Grid InnerCentroNorte-------------------------------
                        Container InnerCentroNorte=new JPanel();
                        InnerCentroNorte.setLayout(new GridLayout(2,4));
                        
                        lSolicitante = new JLabel("Solicitante",SwingConstants.CENTER);                     
                        
                        InnerCentroNorte.add(lSolicitante);
                        solic= new JTextField();
                        InnerCentroNorte.add(solic);
                        
                        lEmail = new JLabel("E-Mail",SwingConstants.CENTER);
                        
                        InnerCentroNorte.add(lEmail);
                        email = new JTextField();
                        InnerCentroNorte.add(email);
                        
                        
                        lCidade = new JLabel("Cidade",SwingConstants.CENTER);
                        
                        InnerCentroNorte.add(lCidade);
                        cidade = new JTextField();
                        InnerCentroNorte.add(cidade);
                        
                        lEstado = new JLabel("Estado",SwingConstants.CENTER);
                        
                        InnerCentroNorte.add(lEstado);
                        comboEstado = new JComboBox<String>();
                        comboEstado.addItem("AC - Acre");
                        comboEstado.addItem("BA - Bahia");
                        comboEstado.addItem("CE - Ceará");
                        comboEstado.addItem("DF - Dsitríto Federal");
                        comboEstado.addItem("ES - Espírito Santo");
                        comboEstado.addItem("GO - Goiás");
                        comboEstado.addItem("MA - Mato Grosso");
                        comboEstado.addItem("PA - Pará");
                        InnerCentroNorte.add(comboEstado);
                        
                        cCentro.add(BorderLayout.NORTH,InnerCentroNorte);
                        //--Grid InnerCentroCentro------------------------------
                        Container InnerCentroCentro = new JPanel();
                        InnerCentroCentro.setLayout(new GridLayout(1,3));
                            //--Grid Checkboxes---------------------------------
                            Container checkBoxes = new JPanel();
                            checkBoxes.setLayout(new GridLayout(5,2));
                            
                            Font fonte2 = new Font("sansserif",Font.BOLD,18);
                            Font fonte3 = new Font("sansserif",Font.BOLD,14);
                            
                            tipoServ = new JLabel("Tipo de Serviço de T.I.");
                            tipoServ.setFont(fonte3);
                            checkBoxes.add(tipoServ);
                            checkBoxes.add(new JLabel(" "));
                            
                            hard = new JCheckBox();
                            hard.addItemListener(this);
                            checkBoxes.add(hard);
                            
                            lHard = new JLabel("HARD",SwingConstants.LEFT);
                            checkBoxes.add(lHard);
                            
                            
                            soft = new JCheckBox();
                            soft.addItemListener(this);
                            checkBoxes.add(soft);
                            
                            lSoft = new JLabel("SOFT",SwingConstants.LEFT);
                            checkBoxes.add(lSoft);
                            
                            rede = new JCheckBox();
                            rede.addItemListener(this);
                            checkBoxes.add(rede);
                            
                            lRede = new JLabel("REDE",SwingConstants.LEFT);
                            checkBoxes.add(lRede);
                            
                            outro = new JCheckBox();
                            outro.addItemListener(this);
                            checkBoxes.add(outro);
                            
                            lOutro = new JLabel("OUTRO",SwingConstants.LEFT);
                            checkBoxes.add(lOutro);
                            
                            InnerCentroCentro.add(checkBoxes);
                            
                            //--Grid Descrição ---------------------------------
                            Container descricao = new JPanel();
                            descricao.setLayout(new GridLayout(2,1));
                            
                            lDescricao = new JLabel("Descrição ",SwingConstants.LEFT);
                            lDescricao.setFont(fonte2);
                            descricao.add(lDescricao);
                            tDescricao = new JTextField();
                            descricao.add(tDescricao);
                            
                            InnerCentroCentro.add(descricao);
                            
                            
                        cCentro.add(BorderLayout.CENTER,InnerCentroCentro);
                //-Container SOUTH  botões--------------------------------------
                Container cSouth = new JPanel();
                cSouth.setLayout(new GridLayout(3,4));
                
                cSouth.add(new JLabel ("     "));                
                cSouth.add(new JLabel ("     "));                
                cSouth.add(new JLabel ("     "));                
                cSouth.add(new JLabel ("     "));                
                cSouth.add(new JLabel ("     "));                
                cSouth.add(new JLabel ("     "));
                
                btEnviar = new JButton(" ENVIAR ");                
                cSouth.add(btEnviar);
                btEnviar.addActionListener(this);
                
                cSouth.add(new JLabel ("   "));

                btLimpar = new JButton(" LIMPAR ");
                cSouth.add(btLimpar);
                btLimpar.addActionListener(this);
                
                cSouth.add(new JLabel ("     "));                
                cSouth.add(new JLabel ("     "));                
                cSouth.add(new JLabel ("     "));                
                cSouth.add(new JLabel ("     "));                
                cSouth.add(new JLabel ("     "));
            
            cMain.add(BorderLayout.NORTH,cLogo);
            cMain.add(BorderLayout.CENTER, cCentro);
            cMain.add(BorderLayout.SOUTH,cSouth);
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(650,760);
            setVisible(true);
            
        }
        
    
//========================= M A I N ==============================   
    public static void main(String[] args) {
        new FormularioTi();
        
    }
//========================= E N D main ==============================  
    
    
//-------CHECKBOX LISTENERS---------------------------------------
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        
    }
//-------E N D - checkbox listnrs.--------------------------------

//-------BUTTONS LISTENERS----------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        String janela = "";
        if(email.getText().contains("@")&& email.getText().contains(".")){
            if(e.getSource()==btEnviar){
                janela = "Solicitação do cliente "+ solic.getText()+" cadastrado com sucesso.\n Serviços solicitados : ";

                if(hard.isEnabled()){
                    janela=janela+"hard;";
                }
                if(soft.isSelected()){
                    janela=janela+" soft;";
                }
                if(rede.isSelected()){
                    janela=janela+" rede;";
                }
                if(outro.isSelected()){
                    janela=janela+" outro";
                }

                JOptionPane.showMessageDialog(soft, janela);
            }else if(e.getSource()==btLimpar){
               solic.setText(" ");
            }
        }else{
            janela="Email inválido";
            JOptionPane.showMessageDialog(null, janela);
        }        
        
        
    }
//-------E N D - buttons listnrs.--------------------------------
    
}

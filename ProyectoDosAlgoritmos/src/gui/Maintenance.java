package gui;

import com.mxrck.autocompleter.TextAutoCompleter;
import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.Product;
import domain.TransportUnit;
import domain.User;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import lab_grafos_algoritmos.GraphException;
import tda.CrudMaintenance;
import static tda.LoadTda.batchMap;
import static tda.LoadTda.categoryMap;
import static tda.LoadTda.cellarGraph;

import static tda.LoadTda.transportUnitMap;
import static tda.LoadTda.userList;

/**
 * Interfaz mantenimiento de cada entidad.
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class Maintenance extends javax.swing.JFrame {

    CrudMaintenance crudMaintenance = new CrudMaintenance();

    /**
     * Creates new form Maintenance
     */
    public Maintenance() {
        initComponents();
        
        //Información ComboBox
        comboBoxRole.addItem("Administrador");
        comboBoxRole.addItem("Operador");
        
        updateRoleUserComboBox.addItem("Administrador");
        updateRoleUserComboBox.addItem("Operador");
        
        MinCapacityComboBox.addItem("0");
        MinCapacityComboBox.addItem("1");
        MinCapacityComboBox.addItem("5");
        MinCapacityComboBox.addItem("10");
        
        MaxCapacityComboBox.addItem("1");
        MaxCapacityComboBox.addItem("5");
        MaxCapacityComboBox.addItem("10");
        MaxCapacityComboBox.addItem("30");
        
        unitMeasuredComboBox.addItem("Unidad");
        unitMeasuredComboBox.addItem("Paquete");
        unitMeasuredComboBox.addItem("Caja");
        unitMeasuredComboBox.addItem("Tarima");
        
        Iterator iteratorBatchMap = batchMap.keySet().iterator();
        while (iteratorBatchMap.hasNext()) {
            Integer key = (Integer) iteratorBatchMap.next();
            Batch batch = batchMap.get(key);
            batchCodeComboBox.addItem(batch.getBatchCode());
        }
        
        Iterator iteratorCategoryMap = categoryMap.keySet().iterator();
        while (iteratorCategoryMap.hasNext()) {
            String key = (String) iteratorCategoryMap.next();
            Category category = categoryMap.get(key);
            categoryComboBox.addItem(category.getName());
        }
        
        
    
        //Autocompletar buscar categoría producto 
        TextAutoCompleter textAutoAcompleterSearchCategory = new TextAutoCompleter(searchNameCategoryTextField);
        Iterator iterator = categoryMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Category category = categoryMap.get(key);
            textAutoAcompleterSearchCategory.addItem(category.getName());
        }
        
        //Autocompletar actualizar categoría producto 
        TextAutoCompleter textAutoAcompleterUpdateCategory = new TextAutoCompleter(updateSearchNameCategoryTextField);
        Iterator iterator2 = categoryMap.keySet().iterator();
        while (iterator2.hasNext()) {
            String key = (String) iterator2.next();
            Category category = categoryMap.get(key);
            textAutoAcompleterUpdateCategory.addItem(category.getName());
        }
        
        //Autocompletar borrar categoría producto 
        TextAutoCompleter textAutoAcompleterDeleteCategory = new TextAutoCompleter(deleteCategoryTextField);
        Iterator iterator3 = categoryMap.keySet().iterator();
        while (iterator3.hasNext()) {
            String key = (String) iterator3.next();
            Category category = categoryMap.get(key);
            textAutoAcompleterDeleteCategory.addItem(category.getName());
        }
        
        //Autocompletar buscar usuario
        TextAutoCompleter textAutoCompleterSearchUser = new TextAutoCompleter(serchName);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            textAutoCompleterSearchUser.addItem(user.getUser());
        }

        //Autocompletar actualizar usuario
        TextAutoCompleter textAutoCompleterUpdateUser = new TextAutoCompleter(updateUserTextField);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            textAutoCompleterUpdateUser.addItem(user.getUser());
        }
        
        //Autocompletar actualizar usuario
        TextAutoCompleter textAutoCompleterDeleteUser = new TextAutoCompleter(deleteUserTextField);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            textAutoCompleterDeleteUser.addItem(user.getUser());
        }
        
        //Autocompletar buscar unidad transporte
        TextAutoCompleter textAutoAcompleterSearchTransportUnit = new TextAutoCompleter(searchPlateTextField);
        Iterator iterator4 = transportUnitMap.keySet().iterator();
        while (iterator4.hasNext()) {
            int key = (int) iterator4.next();
            TransportUnit transportUnit = transportUnitMap.get(key);
            textAutoAcompleterSearchTransportUnit.addItem(transportUnit.getPlate());
        }
        
        //Autocompletar actualizar unidad transporte
        TextAutoCompleter textAutoAcompleterUpdateTransportUnit = new TextAutoCompleter(searchUpdateTransportTextField);
        Iterator iterator5 = transportUnitMap.keySet().iterator();
        while (iterator5.hasNext()) {
            int key = (int) iterator5.next();
            TransportUnit transportUnit = transportUnitMap.get(key);
            textAutoAcompleterUpdateTransportUnit.addItem(transportUnit.getPlate());
        }
        
         //Autocompletar borrar unidad transporte
        TextAutoCompleter textAutoAcompleterDeleteTransportUnit = new TextAutoCompleter(deleteTransportTextField);
        Iterator iterator6 = transportUnitMap.keySet().iterator();
        while (iterator6.hasNext()) {
            int key = (int) iterator6.next();
            TransportUnit transportUnit = transportUnitMap.get(key);
            textAutoAcompleterDeleteTransportUnit.addItem(transportUnit.getPlate());
        }
        
        //Autocompletar buscar lote
        TextAutoCompleter textAutoAcompleterSearchBatch = new TextAutoCompleter(searchBatchCodeLabel);
        Iterator iterator7 = batchMap.keySet().iterator();
        while (iterator7.hasNext()) {
            Integer key = (Integer) iterator7.next();
            Batch batch = batchMap.get(key);
            textAutoAcompleterSearchBatch.addItem(batch.getBatchCode());
        }
        
        //Autocompletar actualizar lote
        TextAutoCompleter textAutoAcompleterUpdateBatch = new TextAutoCompleter(updateSearchBatchCodeTextField);
        Iterator iterator8 = batchMap.keySet().iterator();
        while (iterator8.hasNext()) {
            Integer key = (Integer) iterator8.next();
            Batch batch = batchMap.get(key);
            textAutoAcompleterUpdateBatch.addItem(batch.getBatchCode());
        }
        
        //Autocompletar borrar lote
        TextAutoCompleter textAutoAcompleterDeleteBatch = new TextAutoCompleter(deleteBatchTextField);
        Iterator iterator9 = batchMap.keySet().iterator();
        while (iterator9.hasNext()) {
            Integer key = (Integer) iterator9.next();
            Batch batch = batchMap.get(key);
            textAutoAcompleterDeleteBatch.addItem(batch.getBatchCode());
        }
        
        //Autocompletar buscar bodega
        TextAutoCompleter textAutoAcompleterSearchCellar = new TextAutoCompleter(searchCellarTextField);
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            textAutoAcompleterSearchCellar.addItem(cellar.getName());
        }
        
        //Autocompletar actualizar bodega
        TextAutoCompleter textAutoAcompleterUpdateCellar = new TextAutoCompleter(updateSearchCellarTextField);
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            textAutoAcompleterUpdateCellar.addItem(cellar.getName());
        }
        
        //Autocompletar borrar bodega
        TextAutoCompleter textAutoAcompleterDeleteCellar = new TextAutoCompleter(deleteCellarTextField);
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            textAutoAcompleterDeleteCellar.addItem(cellar.getName());
        }
        
        //Autocompletar buscar producto
//        TextAutoCompleter textAutoCompleterSearchProduct = new TextAutoCompleter(searchProductTextField);
//        for (int i = 0; i < productsBinaryTree.recorreArbol().size() ; i++) {
//            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
//            textAutoCompleterSearchProduct.addItem(product);
//        }
        
//        //Autocompletar actualizar producto
//        TextAutoCompleter textAutoCompleterUpdateProduct = new TextAutoCompleter(updateSearchProduct);
//        for (int i = 0; i < productsBinaryTree.recorreArbol().size() ; i++) {
//            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
//            textAutoCompleterUpdateProduct.addItem(product);
//        }
        
//        //Autocompletar borrar producto
//        TextAutoCompleter textAutoCompleterDeleteProduct = new TextAutoCompleter(deleteProductTextField);
//        for (int i = 0; i < productsBinaryTree.recorreArbol().size() ; i++) {
//            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
//            textAutoCompleterDeleteProduct.addItem(product);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField15 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel83 = new javax.swing.JLabel();
        nameCategoryTextField = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        descriptionCategoryTextField = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        searchNameCategoryTextField = new javax.swing.JTextField();
        searchCategoryButton = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        descriptionCategoryLabel = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        updateSearchNameCategoryTextField = new javax.swing.JTextField();
        updateSearchCategoryButton = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        updateNameCategoryTextField = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        updateDescriptionCategoryTextField = new javax.swing.JTextField();
        addCategoryButton = new javax.swing.JButton();
        updateCategoryButton = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        deleteCategoryTextField = new javax.swing.JTextField();
        deleteCategoryButton = new javax.swing.JButton();
        addCategoryLabel = new javax.swing.JLabel();
        searchCategoryLabel = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboBoxRole = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        addUserButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        serchName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        serchUserButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        updateUserTextField = new javax.swing.JTextField();
        updateSearchUserButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        updateNameUserTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        updateRoleUserComboBox = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        updateUserNameTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        updatePasswordTextField = new javax.swing.JPasswordField();
        updateUserButton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        deleteUserTextField = new javax.swing.JTextField();
        deleteUserButton = new javax.swing.JButton();
        jLabel114 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        plateTextField = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        MinCapacityComboBox = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        imageTransportUnitTextField = new javax.swing.JTextField();
        searchImageTransportUnit = new javax.swing.JButton();
        addTransportUnitButton = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        searchPlateTextField = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        capacityTransportUnitLabel = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        imageTransportUnit = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        searchUpdateTransportTextField = new javax.swing.JTextField();
        updateSearchPlateButton = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        plateTransportUnitTexField = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        updateMinCapacityComboBox = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        updateImageTransport = new javax.swing.JTextField();
        updateImageTransportUnit = new javax.swing.JButton();
        updateTransportUnitButton = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        deleteTransportTextField = new javax.swing.JTextField();
        deleteTransportUnitButton = new javax.swing.JButton();
        searchTransportUnitButton = new javax.swing.JButton();
        jLabel134 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        MaxCapacityComboBox = new javax.swing.JComboBox<>();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        updateMaxCapacityComboBox = new javax.swing.JComboBox<>();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel65 = new javax.swing.JLabel();
        codeBatchTextField = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel68 = new javax.swing.JLabel();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel69 = new javax.swing.JLabel();
        searchBatchCodeLabel = new javax.swing.JTextField();
        searchBatchButton = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        packedDateLabel = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        expirationDateLabel = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        updateSearchBatchCodeTextField = new javax.swing.JTextField();
        updateSearchBatchButton = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        batchCodeLabel = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        expirationDatePicker = new org.jdesktop.swingx.JXDatePicker();
        updateBatchButton = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        deleteBatchTextField = new javax.swing.JTextField();
        deleteBatchButton = new javax.swing.JButton();
        addBatchButton = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        cellarNameTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        latitudeCellarTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        LenghtCellarTextField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        distanceCellarTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        imageCellarTextField = new javax.swing.JTextField();
        addImageCellarButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        searchCellarTextField = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        latitudeCellarLabel = new javax.swing.JLabel();
        searchCellarButton = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        lenghtCellarLabel = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        distanceCellarLabel = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        imageCellarLabel = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        updateSearchCellarTextField = new javax.swing.JTextField();
        updateSearchCellarButton = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        updateNameCellarTextField = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        updateLatitudeCellarTextField = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        updateLenghtTextField = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        updateDistanceTextField = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        updateImageTextField = new javax.swing.JTextField();
        updateImageCellarButton = new javax.swing.JButton();
        addCellarButton = new javax.swing.JButton();
        updateCellarButton = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        deleteCellarTextField = new javax.swing.JTextField();
        deleteCellarButton = new javax.swing.JButton();
        jLabel146 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel96 = new javax.swing.JLabel();
        nameProductTextField = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        unitValueTextField = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        totalWeightTextField = new javax.swing.JTextField();
        descriptionProductTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        imageProductTextField = new javax.swing.JTextField();
        searchImageProductButton = new javax.swing.JButton();
        addProductButton = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        searchProductTextField = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        unitMeasuredComboBox = new javax.swing.JComboBox<>();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        updateSearchProduct = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        deleteProductTextField = new javax.swing.JTextField();
        jButton30 = new javax.swing.JButton();
        jTextField35 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        batchCodeComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        returnAdministratorButton = new javax.swing.JButton();

        jTextField15.setText("jTextField15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 153));

        jTabbedPane1.setBackground(new java.awt.Color(153, 204, 153));

        jPanel6.setBackground(new java.awt.Color(153, 204, 153));

        jLabel79.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel79.setText("Agregar");

        jLabel80.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel80.setText("Buscar");

        jLabel81.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel81.setText("Actualizar");

        jLabel82.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel82.setText("Borrar");

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel83.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel83.setText("Nombre:");

        jLabel84.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel84.setText("Descripción:");

        jLabel85.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel85.setText("Nombre:");

        searchCategoryButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        searchCategoryButton.setText("Buscar");
        searchCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCategoryButtonActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel86.setText("Descripción:");

        jLabel88.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel88.setText("Nombre:");

        updateSearchCategoryButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        updateSearchCategoryButton.setText("Buscar");
        updateSearchCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchCategoryButtonActionPerformed(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel89.setText("Nombre:");

        jLabel90.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel90.setText("Descripción:");

        addCategoryButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addCategoryButton.setText("Agregar");
        addCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryButtonActionPerformed(evt);
            }
        });

        updateCategoryButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        updateCategoryButton.setText("Actualizar");
        updateCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCategoryButtonActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel91.setText("Nombre:");

        deleteCategoryButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        deleteCategoryButton.setText("Borrar");
        deleteCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCategoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel79)
                .addGap(180, 180, 180)
                .addComponent(jLabel80)
                .addGap(188, 188, 188)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel82)
                .addGap(113, 113, 113))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel83)
                                    .addComponent(nameCategoryTextField)
                                    .addComponent(jLabel84)
                                    .addComponent(descriptionCategoryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(addCategoryButton)))
                        .addGap(51, 51, 51)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel85)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchNameCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(searchCategoryButton))
                            .addComponent(jLabel86)
                            .addComponent(descriptionCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel90)
                                    .addComponent(jLabel89)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel88)
                                        .addGap(18, 18, 18)
                                        .addComponent(updateSearchNameCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(updateNameCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateDescriptionCategoryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                                .addGap(67, 67, 67))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(updateSearchCategoryButton)
                                        .addGap(56, 56, 56))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(updateCategoryButton)
                                        .addGap(69, 69, 69))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)))))
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(deleteCategoryButton))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel91)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel83)
                                        .addGap(18, 18, 18)
                                        .addComponent(nameCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel84)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(descriptionCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(addCategoryButton))
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator15, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                        .addComponent(jSeparator14)
                                        .addComponent(jSeparator13))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel85)
                                    .addComponent(searchNameCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(searchCategoryButton)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel86)
                                .addGap(18, 18, 18)
                                .addComponent(descriptionCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addCategoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                            .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel88)
                                    .addComponent(updateSearchNameCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(updateSearchCategoryButton)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel89)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateNameCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel90)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateDescriptionCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateCategoryButton))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel91)
                                    .addComponent(deleteCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(deleteCategoryButton)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(searchCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))))
        );

        jTabbedPane1.addTab("Categorías", jPanel6);

        jPanel2.setBackground(new java.awt.Color(153, 204, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Agregar");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 21, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Buscar");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 21, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Actualizar");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Borrar");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 21, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 27, -1, 303));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 21, -1, 309));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 11, -1, 319));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("Nombre:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 39, -1, -1));

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 64, 126, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setText("Rol:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 95, -1, -1));

        jPanel2.add(comboBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 127, 126, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("Usuario:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 165, -1, -1));
        jPanel2.add(userTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 197, 126, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Contraseña:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 235, -1, -1));
        jPanel2.add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 260, 126, -1));

        addUserButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addUserButton.setText("Agregar");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 298, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("Nombre usuario:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 41, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setText("Rol:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        roleLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel2.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 171, 17));
        jPanel2.add(serchName, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 66, 171, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setText("Nombre:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        userNameLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel2.add(userNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 171, 23));

        serchUserButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        serchUserButton.setText("Buscar");
        serchUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serchUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(serchUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel13.setText("Nombre:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 44, -1, -1));
        jPanel2.add(updateUserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 41, 175, -1));

        updateSearchUserButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        updateSearchUserButton.setText("Buscar");
        updateSearchUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(updateSearchUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 72, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel14.setText("Nombre:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 144, -1, -1));
        jPanel2.add(updateNameUserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 141, 156, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel15.setText("Rol:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 182, -1, -1));

        jPanel2.add(updateRoleUserComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 179, 156, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel16.setText("Usuario:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 220, -1, -1));
        jPanel2.add(updateUserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 217, 156, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel17.setText("Contraseña:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 267, -1, -1));
        jPanel2.add(updatePasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 264, 156, -1));

        updateUserButton.setText("Actualizar");
        updateUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(updateUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 302, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel18.setText("Nombre:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 46, -1, -1));
        jPanel2.add(deleteUserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 120, -1));

        deleteUserButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        deleteUserButton.setText("Borrar");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(deleteUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, -1, -1));
        jPanel2.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 210, 20));
        jPanel2.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 200, 30));
        jPanel2.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 240, 20));
        jPanel2.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 200, 20));

        jTabbedPane1.addTab("Usuarios", jPanel2);

        jPanel4.setBackground(new java.awt.Color(153, 204, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel44.setText("Agregar");
        jPanel4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 24, -1, -1));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel45.setText("Buscar");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 24, -1, -1));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel46.setText("Actualizar");
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 24, -1, -1));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel47.setText("Borrar");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 24, -1, -1));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 24, -1, 253));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 24, -1, 253));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 24, -1, 253));

        jLabel48.setText("Placa:");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 62, -1, -1));
        jPanel4.add(plateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 87, 172, -1));

        jLabel49.setText("Capacidad mínima:");
        jPanel4.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 125, -1, -1));

        jPanel4.add(MinCapacityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 50, -1));

        jLabel50.setText("Fotografía:");
        jPanel4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        imageTransportUnitTextField.setEditable(false);
        jPanel4.add(imageTransportUnitTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 72, -1));

        searchImageTransportUnit.setText("Buscar");
        searchImageTransportUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchImageTransportUnitActionPerformed(evt);
            }
        });
        jPanel4.add(searchImageTransportUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        addTransportUnitButton.setText("Agregar");
        addTransportUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTransportUnitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(addTransportUnitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel51.setText("Placa:");
        jPanel4.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 59, -1, -1));
        jPanel4.add(searchPlateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 56, 129, -1));

        jLabel52.setText("Capacidad:");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));
        jPanel4.add(capacityTransportUnitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 118, 14));

        jLabel54.setText("Fotografía:");
        jPanel4.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));
        jPanel4.add(imageTransportUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 110, 80));

        jLabel56.setText("Placa:");
        jPanel4.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 59, -1, -1));
        jPanel4.add(searchUpdateTransportTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 56, 132, -1));

        updateSearchPlateButton.setText("Buscar");
        updateSearchPlateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchPlateButtonActionPerformed(evt);
            }
        });
        jPanel4.add(updateSearchPlateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 87, -1, -1));

        jLabel57.setText("Placa:");
        jPanel4.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 144, -1, -1));
        jPanel4.add(plateTransportUnitTexField, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 141, 131, -1));

        jLabel58.setText("Capacidad mínima:");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, -1, -1));

        jPanel4.add(updateMinCapacityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 50, -1));

        jLabel59.setText("Fotografía:");
        jPanel4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        updateImageTransport.setEditable(false);
        jPanel4.add(updateImageTransport, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 73, -1));

        updateImageTransportUnit.setText("Buscar");
        updateImageTransportUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateImageTransportUnitActionPerformed(evt);
            }
        });
        jPanel4.add(updateImageTransportUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, -1, -1));

        updateTransportUnitButton.setText("Actualizar");
        updateTransportUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTransportUnitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(updateTransportUnitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, -1));

        jLabel60.setText("Placa:");
        jPanel4.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 57, -1, -1));
        jPanel4.add(deleteTransportTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 89, 150, -1));

        deleteTransportUnitButton.setText("Borrar");
        deleteTransportUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTransportUnitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(deleteTransportUnitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, -1, -1));

        searchTransportUnitButton.setText("Buscar");
        searchTransportUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTransportUnitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(searchTransportUnitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));
        jPanel4.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 210, 20));

        jLabel140.setText("Capacidad máxima:");
        jPanel4.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jPanel4.add(MaxCapacityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 50, 20));

        jLabel141.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel141.setText("toneladas");
        jPanel4.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 154, 70, 20));

        jLabel142.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel142.setText("toneladas");
        jPanel4.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 80, -1));
        jPanel4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 220, 20));

        jLabel55.setText("toneladas");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, -1, -1));

        jLabel143.setText("Capacidad máxima");
        jPanel4.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, -1, -1));

        jPanel4.add(updateMaxCapacityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 50, -1));

        jLabel144.setText("toneladas");
        jPanel4.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, -1));
        jPanel4.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 200, 20));

        jTabbedPane1.addTab("Transporte", jPanel4);

        jPanel5.setBackground(new java.awt.Color(153, 204, 153));

        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel61.setText("Agregar");

        jLabel62.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel62.setText("Buscar");

        jLabel63.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel63.setText("Actualizar");

        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel64.setText("Borrar");

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel65.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel65.setText("Código lote:");

        jLabel66.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel66.setText("Fecha empacado:");

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel68.setText("Fecha vencimiento:");

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel69.setText("Código lote:");

        searchBatchButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        searchBatchButton.setText("Buscar");
        searchBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBatchButtonActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel70.setText("Fecha empacado:");

        packedDateLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel72.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel72.setText("Fecha vencimiento:");

        expirationDateLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel74.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel74.setText("Código lote:");

        updateSearchBatchButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        updateSearchBatchButton.setText("Buscar");
        updateSearchBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchBatchButtonActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel75.setText("Código lote:");

        jLabel77.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel77.setText("Fecha vencimiento:");

        updateBatchButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        updateBatchButton.setText("Actualizar");
        updateBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBatchButtonActionPerformed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel78.setText("Código lote:");

        deleteBatchButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        deleteBatchButton.setText("Borrar");
        deleteBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBatchButtonActionPerformed(evt);
            }
        });

        addBatchButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addBatchButton.setText("Agregar");
        addBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBatchButtonActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel61))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel68)
                                    .addComponent(jLabel65)
                                    .addComponent(codeBatchTextField)
                                    .addComponent(jLabel66)
                                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel62))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(expirationDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(packedDateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel69)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchBatchCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBatchButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(addBatchButton))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(102, 102, 102)
                                            .addComponent(jLabel63))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(updateSearchBatchButton)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel74)
                                            .addComponent(jLabel75)
                                            .addComponent(jLabel77))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(updateSearchBatchCodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                                    .addComponent(batchCodeLabel)))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(expirationDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(updateBatchButton)
                                .addGap(131, 131, 131)))
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(deleteBatchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(deleteBatchButton)
                                        .addGap(66, 66, 66))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel64))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel78))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel78)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBatchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(deleteBatchButton)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel63)
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel74)
                                                .addComponent(updateSearchBatchCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(updateSearchBatchButton)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel75)
                                                .addComponent(batchCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(46, 46, 46)
                                            .addComponent(jLabel77))
                                        .addComponent(expirationDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateBatchButton))
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel69)
                                    .addComponent(searchBatchCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBatchButton)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel70)
                                .addGap(18, 18, 18)
                                .addComponent(packedDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel72)
                                .addGap(28, 28, 28)
                                .addComponent(expirationDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel65)
                                .addGap(18, 18, 18)
                                .addComponent(codeBatchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel66)
                                .addGap(18, 18, 18)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel68)
                                .addGap(18, 18, 18)
                                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(addBatchButton))
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lotes", jPanel5);

        jPanel3.setBackground(new java.awt.Color(153, 204, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel19.setText("Agregar");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 22, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel20.setText("Buscar");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel21.setText("Actualizar");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel22.setText("Borrar");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 22, -1, 280));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 22, -1, 280));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, 280));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel23.setText("Nombre:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, -1, -1));
        jPanel3.add(cellarNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 48, 151, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel24.setText("Latitud:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, -1, -1));
        jPanel3.add(latitudeCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, 151, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel25.setText("Longitud:");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        jPanel3.add(LenghtCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 151, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel26.setText("Distancia:");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 186, -1, -1));
        jPanel3.add(distanceCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 218, 151, -1));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel27.setText("Fotografía:");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 249, -1, -1));

        imageCellarTextField.setEditable(false);
        jPanel3.add(imageCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 62, -1));

        addImageCellarButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addImageCellarButton.setText("Buscar");
        addImageCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImageCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addImageCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 274, -1, -1));

        jButton3.setText("Agregar");
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 375, -1, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel28.setText("Nombre:");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 46, -1, -1));
        jPanel3.add(searchCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 43, 153, -1));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel29.setText("Latitud:");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 100, -1, -1));

        latitudeCellarLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel3.add(latitudeCellarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 100, 114, 14));

        searchCellarButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        searchCellarButton.setText("Buscar");
        searchCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(searchCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 69, -1, -1));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel31.setText("Longitud:");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 143, -1, -1));

        lenghtCellarLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel3.add(lenghtCellarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 138, 114, 19));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel33.setText("Distancia:");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 186, -1, -1));

        distanceCellarLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel3.add(distanceCellarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 186, 114, 14));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel35.setText("Fotografía:");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 230, -1, -1));
        jPanel3.add(imageCellarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 255, 140, 56));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel37.setText("Nombre:");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));
        jPanel3.add(updateSearchCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 42, 149, -1));

        updateSearchCellarButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        updateSearchCellarButton.setText("Buscar");
        updateSearchCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateSearchCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 68, -1, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel38.setText("Nombre:");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 107, -1, -1));
        jPanel3.add(updateNameCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 104, 149, -1));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel39.setText("Latitud:");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 145, -1, -1));
        jPanel3.add(updateLatitudeCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 142, 149, -1));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel40.setText("Longitud:");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 183, -1, -1));
        jPanel3.add(updateLenghtTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 180, 149, -1));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel41.setText("Distancia:");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 221, -1, -1));
        jPanel3.add(updateDistanceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 218, 149, -1));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel42.setText("Fotografía:");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 260, -1, -1));

        updateImageTextField.setEditable(false);
        jPanel3.add(updateImageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 257, 65, -1));

        updateImageCellarButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        updateImageCellarButton.setText("Buscar");
        updateImageCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateImageCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateImageCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 256, -1, -1));

        addCellarButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addCellarButton.setText("Agregar");
        addCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        updateCellarButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        updateCellarButton.setText("Actualizar");
        updateCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, -1, -1));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel43.setText("Nombre:");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));
        jPanel3.add(deleteCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 130, -1));

        deleteCellarButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        deleteCellarButton.setText("Borrar");
        deleteCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(deleteCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, -1, -1));
        jPanel3.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 180, 20));
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 200, 20));
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 250, 20));
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 180, 30));

        jTabbedPane1.addTab("Bodegas", jPanel3);

        jPanel7.setBackground(new java.awt.Color(153, 204, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel92.setText("Agregar");
        jPanel7.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel93.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel93.setText("Buscar");
        jPanel7.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel94.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel94.setText("Actualizar");
        jPanel7.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jLabel95.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel95.setText("Borrar");
        jPanel7.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 21, -1, 271));

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 21, -1, 267));

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 11, 267));

        jLabel96.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel96.setText("Nombre:");
        jPanel7.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        jPanel7.add(nameProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 114, -1));

        jLabel97.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel97.setText("Unidad medida:");
        jPanel7.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 88, -1));

        jLabel98.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel98.setText("Valor unidad:");
        jPanel7.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 75, -1));
        jPanel7.add(unitValueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 114, -1));

        jLabel99.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel99.setText("Peso total:");
        jPanel7.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel100.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel100.setText("Descripción:");
        jPanel7.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel101.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel101.setText("Lote:");
        jPanel7.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel102.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel102.setText("Categoría:");
        jPanel7.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel103.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel103.setText("Precio:");
        jPanel7.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel104.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel104.setText("Fotografía:");
        jPanel7.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));
        jPanel7.add(totalWeightTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 114, -1));
        jPanel7.add(descriptionProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 114, -1));
        jPanel7.add(priceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 114, -1));

        imageProductTextField.setEditable(false);
        jPanel7.add(imageProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 50, -1));

        searchImageProductButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        searchImageProductButton.setText("Buscar");
        jPanel7.add(searchImageProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 70, -1));

        addProductButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addProductButton.setText("Agregar");
        jPanel7.add(addProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        jLabel105.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel105.setText("Nombre:");
        jPanel7.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jPanel7.add(categoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 110, -1));
        jPanel7.add(searchProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 130, -1));

        jButton28.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton28.setText("Buscar");
        jPanel7.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jLabel106.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel106.setText("Unidad medida:");
        jPanel7.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel108.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel108.setText("Valor unidad:");
        jPanel7.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jPanel7.add(unitMeasuredComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 110, -1));

        jLabel109.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel109.setText("Peso total:");
        jPanel7.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));
        jPanel7.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 90, 10));

        jLabel111.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel111.setText("Descripción:");
        jPanel7.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        jLabel113.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel113.setText("Lote:");
        jPanel7.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        jLabel115.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel115.setText("Categoría:");
        jPanel7.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        jLabel117.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel117.setText("Precio:");
        jPanel7.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        jLabel119.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel119.setText("Fotografía:");
        jPanel7.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        jLabel121.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel121.setText("Nombre:");
        jPanel7.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));
        jPanel7.add(updateSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 120, -1));

        jLabel122.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel122.setText("Nuevo nombre:");
        jPanel7.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));
        jPanel7.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 110, -1));

        jButton29.setText("Buscar");
        jPanel7.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, -1, -1));

        jLabel123.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel123.setText("Unidad medida:");
        jPanel7.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        jLabel124.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel124.setText("Valor unidad:");
        jPanel7.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));

        jLabel125.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel125.setText("Peso total:");
        jPanel7.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, -1, -1));

        jLabel126.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel126.setText("Descripción:");
        jPanel7.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, -1, -1));

        jLabel127.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel127.setText("Lote:");
        jPanel7.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, -1, -1));

        jLabel128.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel128.setText("Categoría:");
        jPanel7.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, -1, -1));

        jLabel129.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel129.setText("Precio:");
        jPanel7.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, -1, 20));

        jLabel130.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel130.setText("Fotografía:");
        jPanel7.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, -1, -1));

        jLabel131.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel131.setText("Nombre:");
        jPanel7.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, -1, -1));

        deleteProductTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductTextFieldActionPerformed(evt);
            }
        });
        jPanel7.add(deleteProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 130, -1));

        jButton30.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton30.setText("Borrar");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, -1, -1));
        jPanel7.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 80, -1));
        jPanel7.add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 110, -1));
        jPanel7.add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 110, -1));
        jPanel7.add(jTextField48, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 110, -1));
        jPanel7.add(jTextField49, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 80, -1));
        jPanel7.add(jTextField50, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 110, -1));

        jPanel7.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 80, -1));

        jPanel7.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 100, -1));
        jPanel7.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 100, 10));
        jPanel7.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 100, 10));
        jPanel7.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 100, 20));
        jPanel7.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 100, 20));
        jPanel7.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 100, 10));
        jPanel7.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 100, 20));
        jPanel7.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 70, 40));

        jPanel7.add(batchCodeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 110, -1));

        jTabbedPane1.addTab("Productos", jPanel7);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tuercas.png"))); // NOI18N
        jLabel1.setText("Mantenimientos");

        returnAdministratorButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        returnAdministratorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salir-con-boton-en-esquema.png"))); // NOI18N
        returnAdministratorButton.setText("Salir");
        returnAdministratorButton.setBorderPainted(false);
        returnAdministratorButton.setContentAreaFilled(false);
        returnAdministratorButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnAdministratorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnAdministratorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnAdministratorButton)
                .addGap(50, 50, 50))
            .addComponent(jTabbedPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnAdministratorButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnAdministratorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnAdministratorButtonActionPerformed
        Administrator administrator = new Administrator();
        administrator.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnAdministratorButtonActionPerformed

    private void updateImageCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateImageCellarButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());

            try {
                Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                updateImageTextField.setText(destiny.toString());
            } catch (IOException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jLabel32.setText("Debe seleccionar un archivo");
        }
    }//GEN-LAST:event_updateImageCellarButtonActionPerformed

    private void addCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCellarButtonActionPerformed
        try {
            if(crudMaintenance.existsCellar(cellarNameTextField.getText())) {
                jLabel146.setText("La bodega ya se encuentra registrada.");
            } else if(cellarNameTextField.getText().equals("") || latitudeCellarTextField.getText().equals("") || LenghtCellarTextField.getText().equals("")
                    || distanceCellarTextField.getText().equals("") || imageCellarTextField.getText().equals("")) {
                jLabel146.setText("Ingrese todos los datos.");
            } else {
                crudMaintenance.addCellar(cellarNameTextField.getText(), latitudeCellarTextField.getText(), LenghtCellarTextField.getText(), Float.valueOf(distanceCellarTextField.getText()), imageCellarTextField.getText());
                jLabel146.setText("Bodega agregada.");
                cellarNameTextField.setText("");
                latitudeCellarTextField.setText("");
                LenghtCellarTextField.setText("");
                distanceCellarTextField.setText("");
                imageCellarTextField.setText("");
            }
        } catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addCellarButtonActionPerformed

    private void deleteTransportUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTransportUnitButtonActionPerformed
        if(crudMaintenance.existsTransportUnit(deleteTransportTextField.getText())) {
            crudMaintenance.deleteTransportUnit(deleteTransportTextField.getText());
            jLabel145.setText("Unidad eliminada");
        } else {
            jLabel145.setText("La unidad no se encuentra registrada.");
        }
    }//GEN-LAST:event_deleteTransportUnitButtonActionPerformed

    private void searchBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBatchButtonActionPerformed
       Batch batch = crudMaintenance.getBatch(searchBatchCodeLabel.getText());
        if(crudMaintenance.existsBatch(searchBatchCodeLabel.getText())) {
            packedDateLabel.setText(batch.getPackedDate());
            expirationDateLabel.setText(batch.getExpirationDate().toString());
        } else {
            jLabel71.setText("El lote no se encuentra registrado.");
        }
    }//GEN-LAST:event_searchBatchButtonActionPerformed

    private void updateSearchBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchBatchButtonActionPerformed
        if(crudMaintenance.existsBatch(updateSearchBatchCodeTextField.getText())) {
           Batch bacth = crudMaintenance.getBatch(updateSearchBatchCodeTextField.getText());
           batchCodeLabel.setText(bacth.getBatchCode());
           expirationDatePicker.setDate(bacth.getExpirationDate());
       } else {
           jLabel73.setText("El lote no se encuentra registrado");
       }
    }//GEN-LAST:event_updateSearchBatchButtonActionPerformed

    private void deleteBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBatchButtonActionPerformed
        if(crudMaintenance.existsBatch(deleteBatchTextField.getText())) {
            crudMaintenance.deleteBacth(deleteBatchTextField.getText());
            jLabel76.setText("Lote eliminado");
        } else {
            jLabel76.setText("El lote no se encuentra registrado");
        }
    }//GEN-LAST:event_deleteBatchButtonActionPerformed

    private void deleteProductTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteProductTextFieldActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        if(crudMaintenance.existsUser(userTextField.getText())) {
            jLabel114.setText("El usuario ya se encuentra registrado.");
        } else if(nameTextField.getText().equals("") || comboBoxRole.getSelectedItem().toString().equals("") || userTextField.getText().equals("") 
                || passwordTextField.getText().equals("")) {
            jLabel114.setText("Ingrese todos los datos.");
        } else {
            crudMaintenance.addUser(nameTextField.getText(), comboBoxRole.getSelectedItem().toString(), userTextField.getText(), passwordTextField.getText());
            jLabel114.setText("Usuario agregado");
            nameTextField.setText("");
            userTextField.setText("");
            passwordTextField.setText("");
        }
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void addCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryButtonActionPerformed
        if (crudMaintenance.existsCategory(nameCategoryTextField.getText()) == true) {
            addCategoryLabel.setText("La categoría ya existe.");
        } else if (nameCategoryTextField.getText().equals("") || descriptionCategoryTextField.equals("")) {
            addCategoryLabel.setText("Ingrese la información.");
        } else {
            crudMaintenance.addCategory(nameCategoryTextField.getText(), descriptionCategoryTextField.getText());
            addCategoryLabel.setText("Categoría agregada.");
            nameCategoryTextField.setText("");
            descriptionCategoryTextField.setText("");
        }
    }//GEN-LAST:event_addCategoryButtonActionPerformed

    private void searchCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCategoryButtonActionPerformed
        Category category = crudMaintenance.getCategory(searchNameCategoryTextField.getText());
        if (searchNameCategoryTextField.getText().equals(category.getName())) {
            jLabel107.setText("");
            descriptionCategoryLabel.setText(category.getDescription());
        } else {
            jLabel107.setText("La categoría no se encuentra registrada.");
        }
    }//GEN-LAST:event_searchCategoryButtonActionPerformed

    private void updateSearchCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchCategoryButtonActionPerformed
        if(crudMaintenance.existsCategory(updateSearchNameCategoryTextField.getText())) {
            Category category = crudMaintenance.getCategory(updateSearchNameCategoryTextField.getText());
            updateNameCategoryTextField.setText(category.getName());
            updateDescriptionCategoryTextField.setText(category.getDescription());
        } else {
            jLabel87.setText("La categoría no se encuentra registrada.");
        }
    }//GEN-LAST:event_updateSearchCategoryButtonActionPerformed

    private void updateCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCategoryButtonActionPerformed
        try {
            if (updateNameCategoryTextField.getText().equals("") || updateDescriptionCategoryTextField.getText().equals("")) {
                jLabel87.setText("Debe ingresar todos los datos.");         
            } else {
               crudMaintenance.updateCategory(updateSearchNameCategoryTextField.getText(), updateNameCategoryTextField.getText(), updateDescriptionCategoryTextField.getText());
                jLabel87.setText("Información actualizada.");
                updateSearchNameCategoryTextField.setText("");
                updateNameCategoryTextField.setText("");
                updateDescriptionCategoryTextField.setText(""); 
            }
        } catch (NullPointerException nullPointerException) {
            jLabel87.setText("Debe ingresar todos los datos.");
        }
    }//GEN-LAST:event_updateCategoryButtonActionPerformed

    private void deleteCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCategoryButtonActionPerformed
        if(crudMaintenance.existsCategory(deleteCategoryTextField.getText())) {
            crudMaintenance.deleteCategory(deleteCategoryTextField.getText());
            jLabel112.setText("Categoría eliminada");
        } else {
            jLabel112.setText("La categoría no se encuentra registrada.");
        }
    }//GEN-LAST:event_deleteCategoryButtonActionPerformed

    private void serchUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serchUserButtonActionPerformed
        User user = crudMaintenance.getUser(serchName.getText());
        if(crudMaintenance.existsUser(serchName.getText())) {
            roleLabel.setText(user.getRole());
            userNameLabel.setText(user.getName());
        } else {
            jLabel118.setText("El usuario no se encuentra registrado.");
        }
    }//GEN-LAST:event_serchUserButtonActionPerformed

    private void updateSearchUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchUserButtonActionPerformed
       if(crudMaintenance.existsUser(updateUserTextField.getText())) {
           User user = crudMaintenance.getUser(updateUserTextField.getText());
           updateNameUserTextField.setText(user.getName());
           updateRoleUserComboBox.setSelectedItem(user.getRole());
           updateUserNameTextField.setText(user.getUser());
       } else {
           jLabel116.setText("El usuario no se encuentra registrado");
       }
    }//GEN-LAST:event_updateSearchUserButtonActionPerformed

    private void updateUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserButtonActionPerformed
        if(updateNameUserTextField.getText().equals("") || updateRoleUserComboBox.getSelectedItem().toString().equals("") 
                || updateUserNameTextField.getText().equals("") || updatePasswordTextField.getText().equals("")) {
            jLabel116.setText("Debe ingresar todos los datos");
        } else {
            crudMaintenance.updateUser(updateUserTextField.getText(), updateNameUserTextField.getText(), 
                    updateRoleUserComboBox.getSelectedItem().toString(), updateUserNameTextField.getText(), updatePasswordTextField.getText());
            jLabel116.setText("Información actualizada");
            updateUserTextField.setText("");
            updateNameUserTextField.setText("");
            updateUserNameTextField.setText("");
            updatePasswordTextField.setText("");
        }
    }//GEN-LAST:event_updateUserButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        if(crudMaintenance.existsUser(deleteUserTextField.getText())) {
            crudMaintenance.deleteUser(deleteUserTextField.getText());
            jLabel120.setText("Usuario eliminado");
        } else {
            jLabel120.setText("El usuario no se encuentra registrado");
        }
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    private void addTransportUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTransportUnitButtonActionPerformed
        if(crudMaintenance.existsTransportUnit(plateTextField.getText())) {
            jLabel134.setText("La unidad ya se encuentra registrada");
        } else if(plateTextField.getText().equals("") || MinCapacityComboBox.getSelectedItem().toString().equals("") || imageTransportUnitTextField.getText().equals("")) {
            jLabel134.setText("Ingrese todos los datos.");
        } else {
            crudMaintenance.addTransportUnit(plateTextField.getText(), Integer.parseInt((String) MinCapacityComboBox.getSelectedItem()), Integer.parseInt((String) MaxCapacityComboBox.getSelectedItem()), imageTransportUnitTextField.getText());
            jLabel134.setText("Unidad agregada");
            plateTextField.setText("");
            imageTransportUnitTextField.setText("");
        }
    }//GEN-LAST:event_addTransportUnitButtonActionPerformed

    private void searchImageTransportUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchImageTransportUnitActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());

            try {
                Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                imageTransportUnitTextField.setText(destiny.toString());
            } catch (IOException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jLabel70.setText("Debe seleccionar un archivo");
        }

    }//GEN-LAST:event_searchImageTransportUnitActionPerformed

    private void searchTransportUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTransportUnitButtonActionPerformed
       TransportUnit transportUnit = crudMaintenance.getTransportUnit(searchPlateTextField.getText());
        if(crudMaintenance.existsTransportUnit(searchPlateTextField.getText())) {
            capacityTransportUnitLabel.setText(transportUnit.getMinCapacity() + "-" + transportUnit.getMaxCapacity());
            System.out.println(transportUnit.getUrl());
            ImageIcon imageIcon = new ImageIcon(transportUnit.getUrl());
            imageTransportUnit.setIcon((Icon)imageIcon);
        } else {
            jLabel118.setText("El usuario no se encuentra registrado.");
        }
    }//GEN-LAST:event_searchTransportUnitButtonActionPerformed

    private void updateImageTransportUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateImageTransportUnitActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());

            try {
                Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                updateImageTransport.setText(destiny.toString());
            } catch (IOException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jLabel53.setText("Debe seleccionar un archivo");
        }
    }//GEN-LAST:event_updateImageTransportUnitActionPerformed

    private void updateSearchPlateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchPlateButtonActionPerformed
        if(crudMaintenance.existsTransportUnit(searchUpdateTransportTextField.getText())) {
           TransportUnit transportUnit = crudMaintenance.getTransportUnit(searchUpdateTransportTextField.getText());
           plateTransportUnitTexField.setText(transportUnit.getPlate());
           updateMinCapacityComboBox.setSelectedItem(transportUnit.getMinCapacity());
           updateMaxCapacityComboBox.setSelectedItem(transportUnit.getMaxCapacity());
           updateImageTransport.setText(transportUnit.getUrl());
       } else {
           jLabel116.setText("El usuario no se encuentra registrado");
       }
    }//GEN-LAST:event_updateSearchPlateButtonActionPerformed

    private void updateTransportUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTransportUnitButtonActionPerformed
       if(plateTransportUnitTexField.getText().equals("") || updateImageTransport.getText().equals("")) {
           jLabel53.setText("Debe ingresar todos los datos");
       } else {
           crudMaintenance.updateTransportUnit(searchUpdateTransportTextField.getText(), plateTransportUnitTexField.getText(), 
                   Integer.parseInt(updateMinCapacityComboBox.getSelectedItem().toString()), 
                   Integer.parseInt(updateMaxCapacityComboBox.getSelectedItem().toString()), updateImageTransport.getText());
           jLabel53.setText("Información actualizada");
           plateTransportUnitTexField.setText("");
           updateImageTransport.setText("");
       }
    }//GEN-LAST:event_updateTransportUnitButtonActionPerformed

    private void addBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBatchButtonActionPerformed
        if (crudMaintenance.existsBatch(codeBatchTextField.getText())) {
            jLabel67.setText("El lote ya se encuentra registrado.");
        } else if (codeBatchTextField.getText().equals("") || jXDatePicker1.getDate().toString().equals("") || jXDatePicker2.getDate().toString().equals("")) {
            jLabel67.setText("Ingrese todos los datos.");
        } else {
            Date date = new Date();
            crudMaintenance.addBacth(codeBatchTextField.getText(), jXDatePicker1.getDate()+" "+date.getHours()+ ":" +date.getMinutes(), jXDatePicker2.getDate());
            jLabel67.setText("Lote agregado");
            codeBatchTextField.setText("");
        }
    }//GEN-LAST:event_addBatchButtonActionPerformed

    private void updateBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBatchButtonActionPerformed
       if(batchCodeLabel.getText().equals("") || expirationDatePicker.getDate().toString().equals("")) {
           jLabel73.setText("Debe ingresar todos los datos");
       } else {
           crudMaintenance.updateBacth(updateSearchBatchCodeTextField.getText(), batchCodeLabel.getText(), "", expirationDatePicker.getDate());
           jLabel73.setText("Información actualizada");
           updateSearchBatchCodeTextField.setText("");
           batchCodeLabel.setText("");
       }
    }//GEN-LAST:event_updateBatchButtonActionPerformed

    private void addImageCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImageCellarButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());

            try {
                Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                imageCellarTextField.setText(destiny.toString());
            } catch (IOException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jLabel146.setText("Debe seleccionar un archivo");
        }
    }//GEN-LAST:event_addImageCellarButtonActionPerformed

    private void searchCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCellarButtonActionPerformed
        try {
            Cellar cellar = crudMaintenance.getCellar(searchCellarTextField.getText());
            if (crudMaintenance.existsCellar(searchCellarTextField.getText())) {
                latitudeCellarLabel.setText(cellar.getLatitude());
                lenghtCellarLabel.setText(cellar.getLength());
                distanceCellarLabel.setText(String.valueOf(cellar.getDistance()));
                ImageIcon imageIcon = new ImageIcon(cellar.getUrl());
                imageCellarLabel.setIcon((Icon) imageIcon);
            } else {
                jLabel30.setText("La bodega no se encuentra registrada.");
            }
        } catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchCellarButtonActionPerformed

    private void updateSearchCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchCellarButtonActionPerformed
        try {
            if(crudMaintenance.existsCellar(updateSearchCellarTextField.getText())) {
                Cellar cellar = crudMaintenance.getCellar(updateSearchCellarTextField.getText());
                updateNameCellarTextField.setText(cellar.getName());
                updateLatitudeCellarTextField.setText(cellar.getLatitude());
                updateLenghtTextField.setText(cellar.getLength());
                updateDistanceTextField.setText(String.valueOf(cellar.getDistance()));
                updateImageTextField.setText(cellar.getUrl());
            } else {
                jLabel32.setText("La bodega no se encuentra registrado");
            }} catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateSearchCellarButtonActionPerformed

    private void updateCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCellarButtonActionPerformed
        try {
            if (updateNameCellarTextField.getText().equals("") || updateLatitudeCellarTextField.getText().equals("")
                    || updateLenghtTextField.getText().equals("") || updateDistanceTextField.getText().equals("") || updateImageTextField.getText().equals("")) {
                jLabel32.setText("Debe ingresar todos los datos");
            } else {

                crudMaintenance.updateCellar(updateSearchCellarTextField.getText(), updateNameCellarTextField.getText(),
                        updateLatitudeCellarTextField.getText(), updateLenghtTextField.getText(), Float.valueOf(updateDistanceTextField.getText()),
                        updateImageTextField.getText());
                jLabel32.setText("Información actualizada");
                updateSearchCellarTextField.setText("");
                updateNameCellarTextField.setText("");
                updateLatitudeCellarTextField.setText("");
                updateLenghtTextField.setText("");
                updateDistanceTextField.setText("");
                updateImageTextField.setText("");
            }
        } catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateCellarButtonActionPerformed

    private void deleteCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCellarButtonActionPerformed
        try {
            if(crudMaintenance.existsCellar(deleteCellarTextField.getText())) {
                crudMaintenance.deleteCellar(deleteCellarTextField.getText());
                jLabel34.setText("Bodega eliminada.");
            } else {
                jLabel34.setText("La bodega no se encuentra registrada.");
            }
        } catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteCellarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maintenance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LenghtCellarTextField;
    private javax.swing.JComboBox<String> MaxCapacityComboBox;
    private javax.swing.JComboBox<String> MinCapacityComboBox;
    private javax.swing.JButton addBatchButton;
    private javax.swing.JButton addCategoryButton;
    private javax.swing.JLabel addCategoryLabel;
    private javax.swing.JButton addCellarButton;
    private javax.swing.JButton addImageCellarButton;
    private javax.swing.JButton addProductButton;
    private javax.swing.JButton addTransportUnitButton;
    private javax.swing.JButton addUserButton;
    private javax.swing.JComboBox<String> batchCodeComboBox;
    private javax.swing.JTextField batchCodeLabel;
    private javax.swing.JLabel capacityTransportUnitLabel;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JTextField cellarNameTextField;
    private javax.swing.JTextField codeBatchTextField;
    private javax.swing.JComboBox<String> comboBoxRole;
    private javax.swing.JButton deleteBatchButton;
    private javax.swing.JTextField deleteBatchTextField;
    private javax.swing.JButton deleteCategoryButton;
    private javax.swing.JTextField deleteCategoryTextField;
    private javax.swing.JButton deleteCellarButton;
    private javax.swing.JTextField deleteCellarTextField;
    private javax.swing.JTextField deleteProductTextField;
    private javax.swing.JTextField deleteTransportTextField;
    private javax.swing.JButton deleteTransportUnitButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JTextField deleteUserTextField;
    private javax.swing.JLabel descriptionCategoryLabel;
    private javax.swing.JTextField descriptionCategoryTextField;
    private javax.swing.JTextField descriptionProductTextField;
    private javax.swing.JLabel distanceCellarLabel;
    private javax.swing.JTextField distanceCellarTextField;
    private javax.swing.JLabel expirationDateLabel;
    private org.jdesktop.swingx.JXDatePicker expirationDatePicker;
    private javax.swing.JLabel imageCellarLabel;
    private javax.swing.JTextField imageCellarTextField;
    private javax.swing.JTextField imageProductTextField;
    private javax.swing.JLabel imageTransportUnit;
    private javax.swing.JTextField imageTransportUnitTextField;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JLabel latitudeCellarLabel;
    private javax.swing.JTextField latitudeCellarTextField;
    private javax.swing.JLabel lenghtCellarLabel;
    private javax.swing.JTextField nameCategoryTextField;
    private javax.swing.JTextField nameProductTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel packedDateLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField plateTextField;
    private javax.swing.JTextField plateTransportUnitTexField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JButton returnAdministratorButton;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton searchBatchButton;
    private javax.swing.JTextField searchBatchCodeLabel;
    private javax.swing.JButton searchCategoryButton;
    private javax.swing.JLabel searchCategoryLabel;
    private javax.swing.JButton searchCellarButton;
    private javax.swing.JTextField searchCellarTextField;
    private javax.swing.JButton searchImageProductButton;
    private javax.swing.JButton searchImageTransportUnit;
    private javax.swing.JTextField searchNameCategoryTextField;
    private javax.swing.JTextField searchPlateTextField;
    private javax.swing.JTextField searchProductTextField;
    private javax.swing.JButton searchTransportUnitButton;
    private javax.swing.JTextField searchUpdateTransportTextField;
    private javax.swing.JTextField serchName;
    private javax.swing.JButton serchUserButton;
    private javax.swing.JTextField totalWeightTextField;
    private javax.swing.JComboBox<String> unitMeasuredComboBox;
    private javax.swing.JTextField unitValueTextField;
    private javax.swing.JButton updateBatchButton;
    private javax.swing.JButton updateCategoryButton;
    private javax.swing.JButton updateCellarButton;
    private javax.swing.JTextField updateDescriptionCategoryTextField;
    private javax.swing.JTextField updateDistanceTextField;
    private javax.swing.JButton updateImageCellarButton;
    private javax.swing.JTextField updateImageTextField;
    private javax.swing.JTextField updateImageTransport;
    private javax.swing.JButton updateImageTransportUnit;
    private javax.swing.JTextField updateLatitudeCellarTextField;
    private javax.swing.JTextField updateLenghtTextField;
    private javax.swing.JComboBox<String> updateMaxCapacityComboBox;
    private javax.swing.JComboBox<String> updateMinCapacityComboBox;
    private javax.swing.JTextField updateNameCategoryTextField;
    private javax.swing.JTextField updateNameCellarTextField;
    private javax.swing.JTextField updateNameUserTextField;
    private javax.swing.JPasswordField updatePasswordTextField;
    private javax.swing.JComboBox<String> updateRoleUserComboBox;
    private javax.swing.JButton updateSearchBatchButton;
    private javax.swing.JTextField updateSearchBatchCodeTextField;
    private javax.swing.JButton updateSearchCategoryButton;
    private javax.swing.JButton updateSearchCellarButton;
    private javax.swing.JTextField updateSearchCellarTextField;
    private javax.swing.JTextField updateSearchNameCategoryTextField;
    private javax.swing.JButton updateSearchPlateButton;
    private javax.swing.JTextField updateSearchProduct;
    private javax.swing.JButton updateSearchUserButton;
    private javax.swing.JButton updateTransportUnitButton;
    private javax.swing.JButton updateUserButton;
    private javax.swing.JTextField updateUserNameTextField;
    private javax.swing.JTextField updateUserTextField;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}

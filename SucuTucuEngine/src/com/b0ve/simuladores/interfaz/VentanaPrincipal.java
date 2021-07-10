package com.b0ve.simuladores.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame {
    
    public static final Color COLOR_BG = new Color(0xBDC3C7);
    public static final Color COLOR_BG_HIGHLIGHT = new Color(0x7F8C8D);
    public static final Color COLOR_BG_MENUS = new Color(0x95A5A6);
    public static final Font FUENTE = new Font("Arial", Font.CENTER_BASELINE, 14);
    
    public static final int ANCHO_EDITOR = 2000;
    public static final int ALTO_EDITOR = 2000;

    public VentanaPrincipal() {
        iniciar();
    }
    
    // TODO Agregar la lista de Items a los Menus
    // TODO Agregar MenuListener para las acciones de los botones
    private void iniciar() {
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(600, 450));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.getContentPane().setBackground(COLOR_BG);
        this.setTitle("Digital Computer Sim");
        
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 0));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelPrincipal.setBackground(COLOR_BG);
        panelPrincipal.setAlignmentX(LEFT_ALIGNMENT);
        
        final MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseEntered(final MouseEvent e) {
                JMenu item = (JMenu) e.getSource();
                if (item != null) item.setSelected(true);
            }
            
            @Override
            public void mouseExited(final MouseEvent e) {
                JMenu item = (JMenu) e.getSource();
                if (item != null) item.setSelected(false);
            }
        };
        
        JMenuBar menuSuperior1 = new JMenuBar();
        menuSuperior1.setLayout(new GridBagLayout());
        menuSuperior1.setAlignmentX(LEFT_ALIGNMENT);
        menuSuperior1.setBackground(COLOR_BG_MENUS);
        menuSuperior1.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.insets = new Insets(5, 0, 1, 0);
        
        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setFont(FUENTE);
        menuArchivo.setForeground(Color.BLACK);
        menuArchivo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menuArchivo.addMouseListener(mouseListener);
        menuSuperior1.add(menuArchivo, gbc1);
        
        JMenu menuEdicion = new JMenu("Edición");
        menuEdicion.setFont(FUENTE);
        menuEdicion.setForeground(Color.BLACK);
        menuEdicion.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menuEdicion.addMouseListener(mouseListener);
        menuSuperior1.add(menuEdicion, gbc1);
        
        JMenu menuCircuito = new JMenu("Circuito");
        menuCircuito.setFont(FUENTE);
        menuCircuito.setForeground(Color.BLACK);
        menuCircuito.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menuCircuito.addMouseListener(mouseListener);
        menuSuperior1.add(menuCircuito, gbc1);
        
        JMenu menuVista = new JMenu("Vista");
        menuVista.setFont(FUENTE);
        menuVista.setForeground(Color.BLACK);
        menuVista.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menuVista.addMouseListener(mouseListener);
        menuSuperior1.add(menuVista, gbc1);
        
        JMenu menuHerramientas = new JMenu("Herramientas");
        menuHerramientas.setFont(FUENTE);
        menuHerramientas.setForeground(Color.BLACK);
        menuHerramientas.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menuHerramientas.addMouseListener(mouseListener);
        menuSuperior1.add(menuHerramientas, gbc1);
        
        JMenu menuAyuda = new JMenu("Ayuda");
        menuAyuda.setFont(FUENTE);
        menuAyuda.setForeground(Color.BLACK);
        menuAyuda.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menuAyuda.addMouseListener(mouseListener);
        menuSuperior1.add(menuAyuda, gbc1);
        
        JPanel wrapperMenuSuperior1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        wrapperMenuSuperior1.setBackground(COLOR_BG_MENUS);
        wrapperMenuSuperior1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BG_HIGHLIGHT),
                BorderFactory.createEmptyBorder(2, 15, 2, 15)));
        wrapperMenuSuperior1.add(menuSuperior1);
        
        JMenuBar menuSuperior2 = new JMenuBar();
        menuSuperior2.setLayout(new GridBagLayout());
        menuSuperior2.setAlignmentX(LEFT_ALIGNMENT);
        menuSuperior2.setBackground(COLOR_BG_MENUS);
        menuSuperior2.setBorder(null);
        
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.CENTER;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(1, 0, 1, 0);
        
        ImageIcon iconoNuevo = new ImageIcon("resources\\icono_archivo.png");
        JMenu menuNuevo = new JMenu();
        menuNuevo.setIcon(iconoNuevo);
        menuNuevo.setBorder(BorderFactory.createEmptyBorder(5, 3, 5, 3));
        menuNuevo.addMouseListener(mouseListener);
        menuSuperior2.add(menuNuevo, gbc2);
        
        ImageIcon iconoAbrir = new ImageIcon("resources\\icono_abrir.png");
        JMenu menuAbrir = new JMenu();
        menuAbrir.setIcon(iconoAbrir);
        menuAbrir.setBorder(BorderFactory.createEmptyBorder(5, 3, 5, 3));
        menuAbrir.addMouseListener(mouseListener);
        menuSuperior2.add(menuAbrir, gbc2);
        
        ImageIcon iconoGuardar = new ImageIcon("resources\\icono_guardar.png");
        JMenu menuGuardar = new JMenu();
        menuGuardar.setIcon(iconoGuardar);
        menuGuardar.setBorder(BorderFactory.createEmptyBorder(5, 3, 5, 3));
        menuGuardar.addMouseListener(mouseListener);
        menuSuperior2.add(menuGuardar, gbc2);
        
        JSeparator separador1MenuSuperior2 = new JSeparator(SwingConstants.VERTICAL);
        separador1MenuSuperior2.setBackground(COLOR_BG_HIGHLIGHT);
        separador1MenuSuperior2.setForeground(COLOR_BG_HIGHLIGHT);
        menuSuperior2.add(Box.createHorizontalStrut(5), gbc2);
        menuSuperior2.add(separador1MenuSuperior2, gbc2);
        menuSuperior2.add(Box.createHorizontalStrut(5), gbc2);
        
        ImageIcon iconoCortar = new ImageIcon("resources\\icono_cortar.png");
        JMenu menuCortar = new JMenu();
        menuCortar.setIcon(iconoCortar);
        menuCortar.setBorder(BorderFactory.createEmptyBorder(5, 3, 5, 3));
        menuCortar.addMouseListener(mouseListener);
        menuSuperior2.add(menuCortar, gbc2);
        
        ImageIcon iconoCopiar = new ImageIcon("resources\\icono_copiar.png");
        JMenu menuCopiar = new JMenu();
        menuCopiar.setIcon(iconoCopiar);
        menuCopiar.setBorder(BorderFactory.createEmptyBorder(5, 3, 5, 3));
        menuCopiar.addMouseListener(mouseListener);
        menuSuperior2.add(menuCopiar, gbc2);
        
        ImageIcon iconoPegar = new ImageIcon("resources\\icono_pegar.png");
        JMenu menuPegar = new JMenu();
        menuPegar.setIcon(iconoPegar);
        menuPegar.setBorder(BorderFactory.createEmptyBorder(5, 3, 5, 3));
        menuPegar.addMouseListener(mouseListener);
        menuSuperior2.add(menuPegar, gbc2);
        
        JSeparator separador2MenuSuperior2 = new JSeparator(SwingConstants.VERTICAL);
        separador2MenuSuperior2.setBackground(COLOR_BG_HIGHLIGHT);
        separador2MenuSuperior2.setForeground(COLOR_BG_HIGHLIGHT);
        menuSuperior2.add(Box.createHorizontalStrut(5), gbc2);
        menuSuperior2.add(separador2MenuSuperior2, gbc2);
        menuSuperior2.add(Box.createHorizontalStrut(5), gbc2);
        
        ImageIcon iconoImprimir = new ImageIcon("resources\\icono_imprimir.png");
        JMenu menuImprimir = new JMenu();
        menuImprimir.setIcon(iconoImprimir);
        menuImprimir.setBorder(BorderFactory.createEmptyBorder(5, 3, 5, 3));
        menuImprimir.addMouseListener(mouseListener);
        menuSuperior2.add(menuImprimir, gbc2);
        
        JPanel wrapperMenuSuperior2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        wrapperMenuSuperior2.setBackground(COLOR_BG_MENUS);
        wrapperMenuSuperior2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BG_HIGHLIGHT),
                BorderFactory.createEmptyBorder(2, 15, 2, 15)));
        wrapperMenuSuperior2.add(menuSuperior2);
        
        JMenuBar menuSuperior3 = new JMenuBar();
        menuSuperior3.setLayout(new GridBagLayout());
        menuSuperior3.setAlignmentX(LEFT_ALIGNMENT);
        menuSuperior3.setBackground(COLOR_BG_MENUS);
        menuSuperior3.setBorder(null);
        
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.anchor = GridBagConstraints.CENTER;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(1, 0, 1, 0);
        
        ImageIcon iconoOR = new ImageIcon("resources\\icono_puerta_or.png");
        JMenu menuPuertaOR = new JMenu();
        menuPuertaOR.setIcon(iconoOR);
        menuPuertaOR.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuPuertaOR.addMouseListener(mouseListener);
        menuSuperior3.add(menuPuertaOR, gbc3);
        
        ImageIcon iconoNOR = new ImageIcon("resources\\icono_puerta_nor.png");
        JMenu menuPuertaNOR = new JMenu();
        menuPuertaNOR.setIcon(iconoNOR);
        menuPuertaNOR.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuPuertaNOR.addMouseListener(mouseListener);
        menuSuperior3.add(menuPuertaNOR, gbc3);
        
        ImageIcon iconoXOR = new ImageIcon("resources\\icono_puerta_xor.png");
        JMenu menuPuertaXOR = new JMenu();
        menuPuertaXOR.setIcon(iconoXOR);
        menuPuertaXOR.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuPuertaXOR.addMouseListener(mouseListener);
        menuSuperior3.add(menuPuertaXOR, gbc3);
        
        ImageIcon iconoXNOR = new ImageIcon("resources\\icono_puerta_xnor.png");
        JMenu menuPuertaXNOR = new JMenu();
        menuPuertaXNOR.setIcon(iconoXNOR);
        menuPuertaXNOR.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuPuertaXNOR.addMouseListener(mouseListener);
        menuSuperior3.add(menuPuertaXNOR, gbc3);
        
        ImageIcon iconoNOT = new ImageIcon("resources\\icono_puerta_not.png");
        JMenu menuPuertaNOT = new JMenu();
        menuPuertaNOT.setIcon(iconoNOT);
        menuPuertaNOT.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuPuertaNOT.addMouseListener(mouseListener);
        menuSuperior3.add(menuPuertaNOT, gbc3);
        
        ImageIcon iconoAND = new ImageIcon("resources\\icono_puerta_and.png");
        JMenu menuPuertaAND = new JMenu();
        menuPuertaAND.setIcon(iconoAND);
        menuPuertaAND.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuPuertaAND.addMouseListener(mouseListener);
        menuSuperior3.add(menuPuertaAND, gbc3);
        
        ImageIcon iconoNAND = new ImageIcon("resources\\icono_puerta_nand.png");
        JMenu menuPuertaNAND = new JMenu();
        menuPuertaNAND.setIcon(iconoNAND);
        menuPuertaNAND.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuPuertaNAND.addMouseListener(mouseListener);
        menuSuperior3.add(menuPuertaNAND, gbc3);
        
        ImageIcon iconoTriestado = new ImageIcon("resources\\icono_triestado.png");
        JMenu menuTriestado = new JMenu();
        menuTriestado.setIcon(iconoTriestado);
        menuTriestado.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuTriestado.addMouseListener(mouseListener);
        menuSuperior3.add(menuTriestado, gbc3);
        
        ImageIcon iconoBiestableRS = new ImageIcon("resources\\icono_biestable_rs.png");
        JMenu menuBiestableRS = new JMenu();
        menuBiestableRS.setIcon(iconoBiestableRS);
        menuBiestableRS.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuBiestableRS.addMouseListener(mouseListener);
        menuSuperior3.add(menuBiestableRS, gbc3);
        
        ImageIcon iconoBiestableD = new ImageIcon("resources\\icono_biestable_d.png");
        JMenu menuBiestableD = new JMenu();
        menuBiestableD.setIcon(iconoBiestableD);
        menuBiestableD.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuBiestableD.addMouseListener(mouseListener);
        menuSuperior3.add(menuBiestableD, gbc3);
        
        ImageIcon iconoBiestableJK = new ImageIcon("resources\\icono_biestable_jk.png");
        JMenu menuBiestableJK = new JMenu();
        menuBiestableJK.setIcon(iconoBiestableJK);
        menuBiestableJK.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuBiestableJK.addMouseListener(mouseListener);
        menuSuperior3.add(menuBiestableJK, gbc3);
        
        ImageIcon iconoMemoria = new ImageIcon("resources\\icono_memoria.png");
        JMenu menuMemoria = new JMenu();
        menuMemoria.setIcon(iconoMemoria);
        menuMemoria.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuMemoria.addMouseListener(mouseListener);
        menuSuperior3.add(menuMemoria, gbc3);
        
        ImageIcon iconoTag = new ImageIcon("resources\\icono_tag.png");
        JMenu menuTag = new JMenu();
        menuTag.setIcon(iconoTag);
        menuTag.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuTag.addMouseListener(mouseListener);
        menuSuperior3.add(menuTag, gbc3);
        
        JSeparator separador1MenuSuperior3 = new JSeparator(SwingConstants.VERTICAL);
        separador1MenuSuperior3.setBackground(COLOR_BG_HIGHLIGHT);
        separador1MenuSuperior3.setForeground(COLOR_BG_HIGHLIGHT);
        menuSuperior3.add(Box.createHorizontalStrut(5), gbc3);
        menuSuperior3.add(separador1MenuSuperior3, gbc3);
        menuSuperior3.add(Box.createHorizontalStrut(5), gbc3);
        
        ImageIcon iconoVCC = new ImageIcon("resources\\icono_vcc.png");
        JMenu menuVCC = new JMenu();
        menuVCC.setIcon(iconoVCC);
        menuVCC.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuVCC.addMouseListener(mouseListener);
        menuSuperior3.add(menuVCC, gbc3);
        
        ImageIcon iconoGND = new ImageIcon("resources\\icono_gnd.png");
        JMenu menuGND = new JMenu();
        menuGND.setIcon(iconoGND);
        menuGND.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuGND.addMouseListener(mouseListener);
        menuSuperior3.add(menuGND, gbc3);
        
        ImageIcon iconoBoton = new ImageIcon("resources\\icono_boton.png");
        JMenu menuBoton = new JMenu();
        menuBoton.setIcon(iconoBoton);
        menuBoton.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuBoton.addMouseListener(mouseListener);
        menuSuperior3.add(menuBoton, gbc3);
        
        ImageIcon iconoReloj = new ImageIcon("resources\\icono_reloj.png");
        JMenu menuReloj = new JMenu();
        menuReloj.setIcon(iconoReloj);
        menuReloj.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuReloj.addMouseListener(mouseListener);
        menuSuperior3.add(menuReloj, gbc3);
        
        ImageIcon iconoGeneradorSecuencia = new ImageIcon("resources\\icono_generador_secuencia.png");
        JMenu menuGeneradorSecuencia = new JMenu();
        menuGeneradorSecuencia.setIcon(iconoGeneradorSecuencia);
        menuGeneradorSecuencia.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuGeneradorSecuencia.addMouseListener(mouseListener);
        menuSuperior3.add(menuGeneradorSecuencia, gbc3);
        
        JSeparator separador2MenuSuperior3 = new JSeparator(SwingConstants.VERTICAL);
        separador2MenuSuperior3.setBackground(COLOR_BG_HIGHLIGHT);
        separador2MenuSuperior3.setForeground(COLOR_BG_HIGHLIGHT);
        menuSuperior3.add(Box.createHorizontalStrut(5), gbc3);
        menuSuperior3.add(separador2MenuSuperior3, gbc3);
        menuSuperior3.add(Box.createHorizontalStrut(5), gbc3);
        
        ImageIcon iconoLED = new ImageIcon("resources\\icono_led.png");
        JMenu menuLED = new JMenu();
        menuLED.setIcon(iconoLED);
        menuLED.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuLED.addMouseListener(mouseListener);
        menuSuperior3.add(menuLED, gbc3);
        
        ImageIcon iconoDisplay7S = new ImageIcon("resources\\icono_display_7s.png");
        JMenu menuDisplay7S = new JMenu();
        menuDisplay7S.setIcon(iconoDisplay7S);
        menuDisplay7S.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuDisplay7S.addMouseListener(mouseListener);
        menuSuperior3.add(menuDisplay7S, gbc3);
        
        ImageIcon iconoDisplayBinario = new ImageIcon("resources\\icono_display_binario.png");
        JMenu menuDisplayBinario = new JMenu();
        menuDisplayBinario.setIcon(iconoDisplayBinario);
        menuDisplayBinario.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuDisplayBinario.addMouseListener(mouseListener);
        menuSuperior3.add(menuDisplayBinario, gbc3);
        
        ImageIcon iconoDisplayHexadecimal = new ImageIcon("resources\\icono_display_hexadecimal.png");
        JMenu menuDisplayHexadecimal = new JMenu();
        menuDisplayHexadecimal.setIcon(iconoDisplayHexadecimal);
        menuDisplayHexadecimal.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuDisplayHexadecimal.addMouseListener(mouseListener);
        menuSuperior3.add(menuDisplayHexadecimal, gbc3);
        
        JPanel wrapperMenuSuperior3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        wrapperMenuSuperior3.setBackground(COLOR_BG_MENUS);
        wrapperMenuSuperior3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BG_HIGHLIGHT),
                BorderFactory.createEmptyBorder(2, 15, 2, 15)));
        wrapperMenuSuperior3.add(menuSuperior3);
        
        JMenuBar menuSuperior4 = new JMenuBar();
        menuSuperior4.setLayout(new GridBagLayout());
        menuSuperior4.setAlignmentX(LEFT_ALIGNMENT);
        menuSuperior4.setBackground(COLOR_BG_MENUS);
        menuSuperior4.setBorder(null);
        
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.anchor = GridBagConstraints.CENTER;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(1, 0, 1, 0);
        
        ImageIcon iconoCursor = new ImageIcon("resources\\icono_cursor.png");
        JMenu menuCursor = new JMenu();
        menuCursor.setIcon(iconoCursor);
        menuCursor.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuCursor.addMouseListener(mouseListener);
        menuSuperior4.add(menuCursor, gbc4);
        
        ImageIcon iconoSeleccionar = new ImageIcon("resources\\icono_seleccionar.png");
        JMenu menuSeleccionar = new JMenu();
        menuSeleccionar.setIcon(iconoSeleccionar);
        menuSeleccionar.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuSeleccionar.addMouseListener(mouseListener);
        menuSuperior4.add(menuSeleccionar, gbc4);
        
        ImageIcon iconoZoom = new ImageIcon("resources\\icono_zoom.png");
        JMenu menuZoom = new JMenu();
        menuZoom.setIcon(iconoZoom);
        menuZoom.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuZoom.addMouseListener(mouseListener);
        menuSuperior4.add(menuZoom, gbc4);
        
        ImageIcon iconoInteractuar = new ImageIcon("resources\\icono_interactuar.png");
        JMenu menuInteractuar = new JMenu();
        menuInteractuar.setIcon(iconoInteractuar);
        menuInteractuar.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuInteractuar.addMouseListener(mouseListener);
        menuSuperior4.add(menuInteractuar, gbc4);
        
        ImageIcon iconoProbar = new ImageIcon("resources\\icono_probar.png");
        JMenu menuProbar = new JMenu();
        menuProbar.setIcon(iconoProbar);
        menuProbar.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuProbar.addMouseListener(mouseListener);
        menuSuperior4.add(menuProbar, gbc4);
        
        ImageIcon iconoEscritura = new ImageIcon("resources\\icono_escritura.png");
        JMenu menuEscritura = new JMenu();
        menuEscritura.setIcon(iconoEscritura);
        menuEscritura.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuEscritura.addMouseListener(mouseListener);
        menuSuperior4.add(menuEscritura, gbc4);
        
        ImageIcon iconoCableado = new ImageIcon("resources\\icono_cableado.png");
        JMenu menuCableado = new JMenu();
        menuCableado.setIcon(iconoCableado);
        menuCableado.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuCableado.addMouseListener(mouseListener);
        menuSuperior4.add(menuCableado, gbc4);
        
        JSeparator separador1MenuSuperior4 = new JSeparator(SwingConstants.VERTICAL);
        separador1MenuSuperior4.setBackground(COLOR_BG_HIGHLIGHT);
        separador1MenuSuperior4.setForeground(COLOR_BG_HIGHLIGHT);
        menuSuperior4.add(Box.createHorizontalStrut(5), gbc4);
        menuSuperior4.add(separador1MenuSuperior4, gbc4);
        menuSuperior4.add(Box.createHorizontalStrut(5), gbc4);
        
        ImageIcon iconoComponentes = new ImageIcon("resources\\icono_componentes.png");
        JMenu menuComponentes = new JMenu("Componentes");
        menuComponentes.setIcon(iconoComponentes);
        menuComponentes.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuComponentes.addMouseListener(mouseListener);
        menuSuperior4.add(menuComponentes, gbc4);
        
        JSeparator separador2MenuSuperior4 = new JSeparator(SwingConstants.VERTICAL);
        separador2MenuSuperior4.setBackground(COLOR_BG_HIGHLIGHT);
        separador2MenuSuperior4.setForeground(COLOR_BG_HIGHLIGHT);
        menuSuperior4.add(Box.createHorizontalStrut(5), gbc4);
        menuSuperior4.add(separador2MenuSuperior4, gbc4);
        menuSuperior4.add(Box.createHorizontalStrut(5), gbc4);
        
        ImageIcon iconoIniciarSimulacion = new ImageIcon("resources\\icono_iniciar_simulacion.png");
        JMenu menuIniciarSimulacion = new JMenu();
        menuIniciarSimulacion.setIcon(iconoIniciarSimulacion);
        menuIniciarSimulacion.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuIniciarSimulacion.addMouseListener(mouseListener);
        menuSuperior4.add(menuIniciarSimulacion, gbc4);
        
        ImageIcon iconoDetenerSimulacion = new ImageIcon("resources\\icono_detener_simulacion.png");
        JMenu menuDetenerSimulacion = new JMenu();
        menuDetenerSimulacion.setIcon(iconoDetenerSimulacion);
        menuDetenerSimulacion.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuDetenerSimulacion.addMouseListener(mouseListener);
        menuSuperior4.add(menuDetenerSimulacion, gbc4);
        
        ImageIcon iconoPausarSimulacion = new ImageIcon("resources\\icono_pausar_simulacion.png");
        JMenu menuPausarSimulacion = new JMenu();
        menuPausarSimulacion.setIcon(iconoPausarSimulacion);
        menuPausarSimulacion.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuPausarSimulacion.addMouseListener(mouseListener);
        menuSuperior4.add(menuPausarSimulacion, gbc4);
        
        ImageIcon iconoAvanzarSimulacion = new ImageIcon("resources\\icono_avanzar_simulacion.png");
        JMenu menuAvanzarSimulacion = new JMenu("Ejecución");
        menuAvanzarSimulacion.setIcon(iconoAvanzarSimulacion);
        menuAvanzarSimulacion.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        menuAvanzarSimulacion.addMouseListener(mouseListener);
        menuSuperior4.add(menuAvanzarSimulacion, gbc4);
        
        JPanel wrapperMenuSuperior4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        wrapperMenuSuperior4.setBackground(COLOR_BG_MENUS);
        wrapperMenuSuperior4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BG_HIGHLIGHT),
                BorderFactory.createEmptyBorder(2, 15, 0, 15)));
        wrapperMenuSuperior4.add(menuSuperior4);
        
        JPanel wrapperMenuSuperior = new JPanel();
        wrapperMenuSuperior.setLayout(new BoxLayout(wrapperMenuSuperior, BoxLayout.Y_AXIS));
        wrapperMenuSuperior.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        wrapperMenuSuperior.setAlignmentX(LEFT_ALIGNMENT);
        wrapperMenuSuperior.setBackground(COLOR_BG_MENUS);
        wrapperMenuSuperior.add(wrapperMenuSuperior1);
        wrapperMenuSuperior.add(wrapperMenuSuperior2);
        wrapperMenuSuperior.add(wrapperMenuSuperior3);
        wrapperMenuSuperior.add(wrapperMenuSuperior4);
        panelPrincipal.add(wrapperMenuSuperior, BorderLayout.PAGE_START);
        
        ReglaVentanaPrincipal reglaH = new ReglaVentanaPrincipal(ReglaVentanaPrincipal.HORIZONTAL, true);
        reglaH.setOpaque(true);
        reglaH.setPreferredHeight(24);
        reglaH.setPreferredWidth(ANCHO_EDITOR);
        reglaH.setMinimumSize(reglaH.getPreferredSize());
        ReglaVentanaPrincipal reglaV = new ReglaVentanaPrincipal(ReglaVentanaPrincipal.VERTICAL, true);
        reglaV.setOpaque(true);
        reglaV.setPreferredWidth(24);
        reglaV.setPreferredHeight(ALTO_EDITOR);
        reglaV.setMinimumSize(reglaV.getPreferredSize());
        
        PanelCentralScroll panelCentral = new PanelCentralScroll(reglaH.getIncremento());
        panelCentral.setBorder(BorderFactory.createLineBorder(COLOR_BG_MENUS));
        panelCentral.setBackground(COLOR_BG);
        panelCentral.setPreferredSize(new Dimension(ANCHO_EDITOR, ALTO_EDITOR));
        
        WrapperPanelScroll panelScrollCentral = new WrapperPanelScroll(panelCentral);
        panelScrollCentral.setReglas(reglaH, reglaV);
        panelScrollCentral.setViewportBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelScrollCentral.setColumnHeaderView(reglaH);
        panelScrollCentral.setRowHeaderView(reglaV);
        panelScrollCentral.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelScrollCentral.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelScrollCentral.setBackground(COLOR_BG);
        
        panelPrincipal.add(panelScrollCentral, BorderLayout.CENTER);
        
        this.getContentPane().setLayout(new BorderLayout(10, 15));
        this.getContentPane().add(panelPrincipal);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal vp = new VentanaPrincipal();
            vp.setVisible(true);
        });
    }
    
}

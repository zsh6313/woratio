package com.example.woratio.ui.panel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.example.woratio.App;
import com.example.woratio.utils.PropertyUtil;
import com.example.woratio.utils.UiConsts;

/**
 * 数据库设置面板
 *
 * @author Bob
 */
public class CasBasePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public static JPanel casPanel;
    public static JPanel rebuildLabelPanel;
    public static JPanel createRscriptLabelPanel;
    public static JPanel createExcelLabelPanel;
    public static JPanel dataManageLabelPanel;
    private static JPanel casRebuildModelPanel;

    /**
     * 构造
     */
    public CasBasePanel() {
        initialize();
        addComponent();
        addListener();
    }

    /**
     * 初始化面板
     */
    private void initialize() {
        this.setBackground(UiConsts.MAIN_BACK_COLOR);
        this.setLayout(new BorderLayout());
        casRebuildModelPanel = new CasRebuildModelPanel();
    }

    /**
     * 为面板添加组件
     */
    private void addComponent() {

        this.add(getUpPanel(), BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);

    }

    /**
     * 面板上部
     *
     * @return
     */
    private JPanel getUpPanel() {
        JPanel panelUp = new JPanel();
        panelUp.setBackground(UiConsts.MAIN_BACK_COLOR);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, UiConsts.MAIN_H_GAP, 5));

        JLabel labelTitle = new JLabel(PropertyUtil.getProperty("ds.ui.cas.title"));
        labelTitle.setFont(UiConsts.FONT_TITLE);
        labelTitle.setForeground(UiConsts.TOOL_BAR_BACK_COLOR);
        panelUp.add(labelTitle);

        return panelUp;
    }

    /**
     * 面板中部
     *
     * @return
     */
    private JPanel getCenterPanel() {
        // 中间面板
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(UiConsts.MAIN_BACK_COLOR);
        panelCenter.setLayout(new BorderLayout());

        // 功能列表Panel
        JPanel panelList = new JPanel();
        Dimension preferredSize = new Dimension(160, UiConsts.MAIN_WINDOW_HEIGHT);
        panelList.setPreferredSize(preferredSize);
        panelList.setBackground(new Color(62, 62, 62));
        panelList.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        rebuildLabelPanel = new JPanel();
        rebuildLabelPanel.setBackground(new Color(69, 186, 121));
        rebuildLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        Dimension preferredSizeListItem = new Dimension(160, 48);
        rebuildLabelPanel.setPreferredSize(preferredSizeListItem);

        JLabel rebuildLabel = new JLabel(PropertyUtil.getProperty("ds.ui.base.rebuild.label"));
        Font fontListItem = new Font(PropertyUtil.getProperty("ds.ui.font.family"), 0, 20);
        rebuildLabel.setFont(fontListItem);
        rebuildLabel.setForeground(Color.white);
        rebuildLabelPanel.add(rebuildLabel);

        createRscriptLabelPanel = new JPanel();
        createRscriptLabelPanel.setBackground(UiConsts.TOOL_BAR_BACK_COLOR);
        createRscriptLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        createRscriptLabelPanel.setPreferredSize(preferredSizeListItem);

        JLabel createRscriptLabel = new JLabel(PropertyUtil.getProperty("ds.ui.base.rscript.label"));
        createRscriptLabel.setFont(fontListItem);
        createRscriptLabel.setForeground(Color.white);
        createRscriptLabelPanel.add(createRscriptLabel);

        createExcelLabelPanel = new JPanel();
        createExcelLabelPanel.setBackground(UiConsts.TOOL_BAR_BACK_COLOR);
        createExcelLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        createExcelLabelPanel.setPreferredSize(preferredSizeListItem);

        JLabel createExcelLabel = new JLabel(PropertyUtil.getProperty("ds.ui.base.excel.label"));
        createExcelLabel.setFont(fontListItem);
        createExcelLabel.setForeground(Color.white);
        createExcelLabelPanel.add(createExcelLabel);

        dataManageLabelPanel = new JPanel();
        dataManageLabelPanel.setBackground(UiConsts.TOOL_BAR_BACK_COLOR);
        dataManageLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        dataManageLabelPanel.setPreferredSize(preferredSizeListItem);

        JLabel dataManageLabel = new JLabel(PropertyUtil.getProperty("ds.ui.base.datamanage.label"));
        dataManageLabel.setFont(fontListItem);
        dataManageLabel.setForeground(Color.white);
        dataManageLabelPanel.add(dataManageLabel);

        panelList.add(rebuildLabelPanel);
        panelList.add(createRscriptLabelPanel);
        panelList.add(createExcelLabelPanel);
        panelList.add(dataManageLabelPanel);

        // cas主面板

        casPanel = new JPanel();
        casPanel.setBackground(UiConsts.MAIN_BACK_COLOR);
        casPanel.setLayout(new BorderLayout());
        casPanel.add(casRebuildModelPanel);

        panelCenter.add(panelList, BorderLayout.WEST);
        panelCenter.add(casPanel, BorderLayout.CENTER);

        return panelCenter;
    }

    /**
     * 添加相关组件的事件监听
     */
    private void addListener() {
        rebuildLabelPanel.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                rebuildLabelPanel.setBackground(new Color(69, 186, 121));
                createRscriptLabelPanel.setBackground(UiConsts.TOOL_BAR_BACK_COLOR);
                createExcelLabelPanel.setBackground(UiConsts.TOOL_BAR_BACK_COLOR);
                dataManageLabelPanel.setBackground(UiConsts.TOOL_BAR_BACK_COLOR);

                CasBasePanel.casPanel.removeAll();
                CasBasePanel.casPanel.add(casRebuildModelPanel);
                App.casBasePanel.updateUI();

            }
        });
    }
}

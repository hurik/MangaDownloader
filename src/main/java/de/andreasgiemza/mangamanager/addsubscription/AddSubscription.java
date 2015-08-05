package de.andreasgiemza.mangamanager.addsubscription;

import de.andreasgiemza.mangadownloader.data.Chapter;
import de.andreasgiemza.mangadownloader.data.Manga;
import de.andreasgiemza.mangadownloader.data.MangaList;
import de.andreasgiemza.mangadownloader.gui.dialogs.Loading;
import de.andreasgiemza.mangadownloader.gui.dialogs.SelectSite;
import de.andreasgiemza.mangadownloader.gui.manga.MangaTableModel;
import de.andreasgiemza.mangadownloader.options.Options;
import de.andreasgiemza.mangadownloader.sites.Site;
import de.andreasgiemza.mangadownloader.sites.SiteHelper;
import de.andreasgiemza.mangamanager.MangaManager;
import de.andreasgiemza.mangamanager.data.Subscription;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andreas Giemza <andreas@giemza.net>
 */
public final class AddSubscription extends javax.swing.JDialog {

    private final java.awt.Frame parent;
    // Tables
    private final List<Manga> mangas = new LinkedList<>();
    private final MangaTableModel mangasTableModel = new MangaTableModel(mangas);
    private final List<Chapter> chapters = new LinkedList<>();
    private final ChaptersTableModel chaptersTableModel = new ChaptersTableModel(chapters);
    // Site
    private Site site;
    // Selected manga
    private Manga manga;
    //private Manga lastSelectedManga = null;

    public AddSubscription(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();

        // Set Position
        setLocation(parent.getX() + (parent.getWidth() / 2) - (getWidth() / 2),
                parent.getY() + (parent.getHeight() / 2) - (getHeight() / 2));

        mangaTextField.getDocument().addDocumentListener(
                new MangaDocumentListener(this,
                        mangaTextField, mangaTable));
        mangaTable.getSelectionModel().addListSelectionListener(
                new MangasSelectionListener(this, mangaTable));

        // Setup Chapter List Table
        filterTextField.getDocument().addDocumentListener(
                new FilterDocumentListener(filterTextField, filterTable));

        // Load Manga List
        loadMangas(SiteHelper.getInstance(Options.INSTANCE.getSelectedSource()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sitePanel = new javax.swing.JPanel();
        siteTextField = new javax.swing.JTextField();
        siteButton = new javax.swing.JButton();
        mangaFilterPanel = new javax.swing.JPanel();
        mangaPanel = new javax.swing.JPanel();
        mangaLabel = new javax.swing.JLabel();
        mangaTextField = new javax.swing.JTextField();
        mangaScrollPane = new javax.swing.JScrollPane();
        mangaTable = new javax.swing.JTable();
        filterPanel = new javax.swing.JPanel();
        filterLabel = new javax.swing.JLabel();
        filterTextField = new javax.swing.JTextField();
        filterPreviewLabel = new javax.swing.JLabel();
        filterScrollPane = new javax.swing.JScrollPane();
        filterTable = new javax.swing.JTable();
        cancelButton = new javax.swing.JButton();
        addSubscriptionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add subscription");

        sitePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Site"));

        siteTextField.setEditable(false);
        siteTextField.setText("Please select a site");

        siteButton.setText("Select site");
        siteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sitePanelLayout = new javax.swing.GroupLayout(sitePanel);
        sitePanel.setLayout(sitePanelLayout);
        sitePanelLayout.setHorizontalGroup(
            sitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sitePanelLayout.createSequentialGroup()
                .addComponent(siteTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siteButton))
        );
        sitePanelLayout.setVerticalGroup(
            sitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(siteButton)
                .addComponent(siteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mangaFilterPanel.setLayout(new javax.swing.BoxLayout(mangaFilterPanel, javax.swing.BoxLayout.LINE_AXIS));

        mangaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manga"));

        mangaLabel.setText("Search:");

        mangaTable.setAutoCreateRowSorter(true);
        mangaTable.setModel(mangasTableModel);
        mangaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mangaScrollPane.setViewportView(mangaTable);

        javax.swing.GroupLayout mangaPanelLayout = new javax.swing.GroupLayout(mangaPanel);
        mangaPanel.setLayout(mangaPanelLayout);
        mangaPanelLayout.setHorizontalGroup(
            mangaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangaPanelLayout.createSequentialGroup()
                .addComponent(mangaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mangaTextField))
            .addComponent(mangaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        mangaPanelLayout.setVerticalGroup(
            mangaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mangaPanelLayout.createSequentialGroup()
                .addGroup(mangaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mangaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mangaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mangaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
        );

        mangaFilterPanel.add(mangaPanel);

        filterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));

        filterLabel.setText("Filter:");

        filterPreviewLabel.setText("Filter preview:");

        filterTable.setAutoCreateRowSorter(true);
        filterTable.setModel(chaptersTableModel);
        filterTable.setEnabled(false);
        filterScrollPane.setViewportView(filterTable);

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addComponent(filterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterTextField))
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addComponent(filterPreviewLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterPreviewLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
        );

        mangaFilterPanel.add(filterPanel);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        addSubscriptionButton.setText("Add subscription");
        addSubscriptionButton.setEnabled(false);
        addSubscriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubscriptionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mangaFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(sitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addSubscriptionButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mangaFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSubscriptionButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siteButtonActionPerformed
        SelectSite siteManager = new SelectSite(parent, true, this);
        siteManager.setVisible(true);
    }//GEN-LAST:event_siteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addSubscriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubscriptionButtonActionPerformed
        ((MangaManager) parent).addSubscription(new Subscription(site, manga, filterTextField.getText()));

        dispose();
    }//GEN-LAST:event_addSubscriptionButtonActionPerformed

    public void loadMangas(Site selectedSite) {
        if (selectedSite == null) {
            return;
        }

        if (selectedSite == site) {
            return;
        }

        site = selectedSite;

        resetMangaPanel();
        siteTextField.setText(site.getName());
        Options.INSTANCE.setSelectedSource(selectedSite.getClass().getSimpleName());
        Options.INSTANCE.saveOptions();

        final Loading loading = new Loading(parent, true, getX(), getY(),
                getWidth(), getHeight());
        loading.startRunnable(new Runnable() {

            @Override
            public void run() {
                mangas.addAll(MangaList.load(site));

                mangasTableModel.fireTableDataChanged();

                loading.dispose();
            }
        });
    }

    private void resetMangaPanel() {
        mangaTable.clearSelection();
        mangas.clear();
        mangasTableModel.fireTableDataChanged();
        mangaTextField.setText("");
        manga = null;

        addSubscriptionButton.setEnabled(false);

        resetFilterPanel();
    }

    public void mangaSearchChanged() {
        mangaTable.clearSelection();
        addSubscriptionButton.setEnabled(false);
        manga = null;

        resetFilterPanel();
    }

    private void resetFilterPanel() {
        chapters.clear();
        chaptersTableModel.fireTableDataChanged();
        filterTextField.setText("");
    }

    void mangaSelected(final Manga selectedManga) {
        if (selectedManga == null) {
            return;
        }

        if (selectedManga == manga) {
            return;
        }

        manga = selectedManga;

        resetFilterPanel();

        final Loading loading = new Loading(parent, true, getX(), getY(), getWidth(), getHeight());
        loading.startRunnable(new Runnable() {

            @Override
            public void run() {
                try {
                    chapters.addAll(site.getChapterList(selectedManga));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(parent,
                            "Cant't connect to "
                            + site.getClass()
                            .getSimpleName() + "!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    mangaTable.clearSelection();
                    manga = null;

                    loading.dispose();
                    return;
                }

                chaptersTableModel.fireTableDataChanged();

                addSubscriptionButton.setEnabled(true);

                loading.dispose();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSubscriptionButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JLabel filterPreviewLabel;
    private javax.swing.JScrollPane filterScrollPane;
    private javax.swing.JTable filterTable;
    private javax.swing.JTextField filterTextField;
    private javax.swing.JPanel mangaFilterPanel;
    private javax.swing.JLabel mangaLabel;
    private javax.swing.JPanel mangaPanel;
    private javax.swing.JScrollPane mangaScrollPane;
    private javax.swing.JTable mangaTable;
    private javax.swing.JTextField mangaTextField;
    private javax.swing.JButton siteButton;
    private javax.swing.JPanel sitePanel;
    private javax.swing.JTextField siteTextField;
    // End of variables declaration//GEN-END:variables

}

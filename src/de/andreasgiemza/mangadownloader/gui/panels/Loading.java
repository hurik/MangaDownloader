/*
 * The MIT License
 *
 * Copyright 2015 Andreas Giemza <andreas@giemza.net>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.andreasgiemza.mangadownloader.gui.panels;

import de.andreasgiemza.mangadownloader.data.Manga;
import de.andreasgiemza.mangadownloader.gui.Controller;
import javax.swing.ImageIcon;

/**
 *
 * @author Andreas Giemza <andreas@giemza.net>
 */
public class Loading extends javax.swing.JDialog {

    private final Controller controller;
    private final Manga selectedManga;

    public Loading(java.awt.Frame parent, boolean modal, Controller controller, Manga selectedManga) {
        super(parent, modal);
        initComponents();
        this.controller = controller;
        this.selectedManga = selectedManga;
    }

    @Override
    public void setVisible(boolean b) {
        if (selectedManga == null) {
            new Thread(new WorkerMangaList(this)).start();
        } else {
            new Thread(new WorkerChapterList(this, selectedManga)).start();
        }

        super.setVisible(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loading ...");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        loadingImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("de/andreasgiemza/mangadownloader/gui/icons/loading.gif")));
        getContentPane().add(loadingImage);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel loadingImage;
    // End of variables declaration//GEN-END:variables

    private class WorkerMangaList implements Runnable {

        private final Loading loading;

        public WorkerMangaList(Loading loading) {
            this.loading = loading;
        }

        @Override
        public void run() {
            controller.updateMangaListWorker();
            loading.dispose();
        }
    }

    private class WorkerChapterList implements Runnable {

        private final Loading loading;
        private final Manga selectedManga;

        public WorkerChapterList(Loading loading, Manga selectedManga) {
            this.loading = loading;
            this.selectedManga = selectedManga;
        }

        @Override
        public void run() {
            controller.mangaSelectedWorker(selectedManga);
            loading.dispose();
        }
    }
}

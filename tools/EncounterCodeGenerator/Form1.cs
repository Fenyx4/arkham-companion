using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

using System.IO;

using LumenWorks.Framework.IO.Csv;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_DragDrop(object sender, DragEventArgs e)
        {
            String blah = "blah";

            blah = (String)((Array)e.Data.GetData("FileNameW")).GetValue(0);

            Stream reader = new FileStream(blah, FileMode.Open, FileAccess.Read);
            CsvReader encFile = new CsvReader(new StreamReader(reader), true);

            FileInfo info = new FileInfo(blah);
            Dictionary<String, String> cardIDs = new Dictionary<String, String>();
            try
            {
                TextWriter textWriter = File.CreateText(info.FullName + "_dec" + ".txt");

                while (encFile.ReadNextRecord())
                {
                    String text = encFile[5];
                    text = text.Replace("\n", "<br />");
                    text = text.Replace("'", "''");
                    text = text.Replace("\"", "\\\"");
                    if (!cardIDs.ContainsKey(encFile[1]))
                    {
                        textWriter.WriteLine("db.execSQL(sqlInsertCard + \" (" + encFile[1] + "," + encFile[0] + "," + encFile[2] + ")\");");
                        cardIDs.Add(encFile[1], encFile[1]);
                    }
                    textWriter.WriteLine("db.execSQL(sqlInsertCardEnc + \" (" + encFile[1] + "," + encFile[3] + ")\");");
                    textWriter.WriteLine("db.execSQL(sqlInsertEnc + \" (" + encFile[3] + "," + encFile[4] + ",'" + text + "')\");");
                }

                textWriter.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            reader.Close();
        }

        private void Form1_DragEnter(object sender, DragEventArgs e)
        {
            e.Effect = DragDropEffects.Copy;
        }
    }
}

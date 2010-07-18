
var HTMLEditor = Ext.extend(Ext.form.HtmlEditor, {
addImage : function() {
   var editor = this;
   
   var imgform = new Ext.FormPanel({
    region : 'center',
    labelWidth : 55,
    frame : true,
    bodyStyle : 'padding:5px 5px 0',
    autoScroll : true,
    border : false,
    fileUpload : true,
    items : [{
       xtype : 'textfield',
       fieldLabel : 'ѡ���ļ�',
       name : 'userfile',
       id : 'userfile',
       inputType : 'file',
       allowBlank : false,
       blankText : '�ļ�����Ϊ��',
       height : 25,
       anchor : '98%'
      }],//items end
    buttons : [{
     text : '�ϴ�',
     type : 'submit',
     handler : function() {
      var furl="";
      furl=imgform.form.findField('userfile').getValue();
      var type=furl.substring(furl.length-3).toLowerCase();
      var filename=furl.substring(furl.lastIndexOf("\\")+1);
      if (furl==""||furl==null) {return;}
      if(type!='jpg'&&type!='bmp'&&type!='gif'&&type!='png'){
       alert('��֧��jpg��bmp��gif��png��ʽ��ͼƬ');
       return;
      }
      imgform.form.submit({
       url : '/newsinfo.mvc/AddFiles_newsinfo',
       waitMsg : '�����ϴ�......',
       waitTitle : '��ȴ�',
       method : 'POST',
       success : function() {
        var element = document.createElement("img");
        element.src = "../UploadFile/"+filename;
        element.style.width="300px";
             element.style.height="200px";
        if (Ext.isIE) {
         editor.insertAtCursor(element.outerHTML);
        } else {
         var selection = editor.win.getSelection();
         if (!selection.isCollapsed) {
          selection.deleteFromDocument();
         }
         selection.getRangeAt(0).insertNode(element);
        }
        win.close();
       },
       failure : function(form, action) {
        form.reset();
        if (action.failureType == Ext.form.Action.SERVER_INVALID)
         Ext.MessageBox.alert('����',
           '�ϴ�ʧ�ܣ���֧��jpg��bmp��gif��png��ʽ��ͼƬ');
       
       }
      
      });//imgform.form.submit end
     }//handler end
    }, {
     text : '�ر�',
     type : 'submit',
     handler : function() {
      win.close(this);
     }
    }]//buttons end
   })//imgform end

   var win = new Ext.Window({
      title : "�ϴ�ͼƬ",
      id : 'picwin',
      width : 400,
      height : 120,
      modal : true,
      border : false,
      iconCls:'icon-uploadpic',
      layout : "fit",
      items : imgform

     });
   win.show();
  
},//�ϴ�ͼƬ����չ addImage end
addFile : function() {
   var editor = this;
   var fileform = new Ext.FormPanel({
    region : 'center',
    labelWidth : 55,
    frame : true,
    bodyStyle : 'padding:5px 5px 0',
    autoScroll : true,
    border : false,
    fileUpload : true,
    items : [{
       xtype : 'textfield',
       fieldLabel : 'ѡ���ļ�',
       name : 'userfile_F',
       id : 'userfile_F',
       inputType : 'file',
       allowBlank : false,
       blankText : '�ļ�����Ϊ��',
       height : 25,
       anchor : '98%'
      }],//items end
    buttons : [{
     text : '�ϴ�',
     type : 'submit',
     handler : function() {
      var furl="";//�ļ������ַ
      var fname="";//�ļ�����
      furl=fileform.form.findField('userfile_F').getValue();
      var type=furl.substring(furl.length-3).toLowerCase();
      if (furl==""||furl==null) {return;}
      if(type!='doc'&&type!='xls'){
       alert('��֧���ϴ�doc��xls��ʽ���ļ�!');
       return;
      }
      fname=furl.substring(furl.lastIndexOf("\\")+1);
      fileform.form.submit({
       url : '/newsinfo.mvc/AddFiles_newsinfo',
       waitMsg : '�����ϴ�......',
       waitTitle : '��ȴ�',
       method : 'POST',
       success : function() {
        var element = document.createElement("a");
        element.href = "../UploadFile/"+fname;
        element.target = '_blank';
        element.innerHTML = fname;
        if (Ext.isIE) {
         editor.insertAtCursor(element.outerHTML);
        } else {
         var selection = editor.win.getSelection();
         if (!selection.isCollapsed) {
          selection.deleteFromDocument();
         }
         selection.getRangeAt(0).insertNode(element);

        }
        winFile.close();
       },//success end
       failure : function() {
        form.reset();
        if (action.failureType == Ext.form.Action.SERVER_INVALID)
         Ext.MessageBox.alert('����',
           '�ϴ�ʧ�ܣ���֧���ϴ�doc��xls��ʽ���ļ�!');
       
       }//failure end
      
      });//fileform.form.submit
     }
    }, {
     text : '�ر�',
     type : 'submit',
     handler : function() {
      winFile.close(this);
     }//handler end
    }]//buttons end
   })

   var winFile = new Ext.Window({
      title : "�ϴ�����",
      id : 'picwin',
      width : 400,
      height : 120,
      modal : true,
      border : false,
      layout : "fit",
      iconCls : 'icon-uploadfile',
      items : fileform

     });
   winFile.show();
  
},//�ϴ���������չ  addFile end
createToolbar : function(editor) {
   HTMLEditor.superclass.createToolbar.call(this, editor);
   this.tb.insertButton(16, {
      cls : "x-btn-icon",
      iconCls : "icon-uploadpic",
      handler : this.addImage,
      tooltip : "���ͼƬ",
      scope : this
     });
   this.tb.insertButton(17, {
      cls : "x-btn-icon",
      iconCls : 'icon-uploadfile',
      handler : this.addFile,
      tooltip : "����ļ�",
      scope : this
     });
}
});//HTMLEditor end
Ext.reg('DCJSEditor', HTMLEditor);

object Form1: TForm1
  Left = 192
  Top = 125
  Width = 536
  Height = 369
  Caption = 'Form1'
  Color = clBtnFace
  Font.Charset = ANSI_CHARSET
  Font.Color = clRed
  Font.Height = -24
  Font.Name = 'Times New Roman'
  Font.Style = [fsItalic]
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 27
  object Label1: TLabel
    Left = 80
    Top = 24
    Width = 5
    Height = 23
    Font.Charset = ANSI_CHARSET
    Font.Color = clRed
    Font.Height = -21
    Font.Name = 'Times New Roman'
    Font.Style = [fsItalic]
    ParentFont = False
  end
  object Label2: TLabel
    Left = 96
    Top = 64
    Width = 6
    Height = 27
  end
  object Edit1: TEdit
    Left = 264
    Top = 128
    Width = 193
    Height = 29
    Font.Charset = ANSI_CHARSET
    Font.Color = clBlack
    Font.Height = -19
    Font.Name = 'Times New Roman'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    Text = 'Edit1'
  end
  object Edit2: TEdit
    Left = 264
    Top = 200
    Width = 193
    Height = 27
    Font.Charset = ANSI_CHARSET
    Font.Color = clBlack
    Font.Height = -16
    Font.Name = 'Times New Roman'
    Font.Style = []
    ParentFont = False
    TabOrder = 1
  end
  object Button1: TButton
    Left = 48
    Top = 120
    Width = 73
    Height = 25
    Caption = 'Start'
    Font.Charset = ANSI_CHARSET
    Font.Color = clWindowText
    Font.Height = -19
    Font.Name = 'Times New Roman'
    Font.Style = [fsItalic]
    ParentFont = False
    TabOrder = 2
    OnClick = Button1Click
  end
  object Button2: TButton
    Left = 48
    Top = 160
    Width = 73
    Height = 25
    Caption = 'Stop'
    Font.Charset = ANSI_CHARSET
    Font.Color = clWindowText
    Font.Height = -19
    Font.Name = 'Times New Roman'
    Font.Style = [fsItalic]
    ParentFont = False
    TabOrder = 3
    OnClick = Button2Click
  end
  object Button3: TButton
    Left = 48
    Top = 208
    Width = 73
    Height = 25
    Caption = 'Zero'
    Font.Charset = ANSI_CHARSET
    Font.Color = clWindowText
    Font.Height = -19
    Font.Name = 'Times New Roman'
    Font.Style = [fsItalic]
    ParentFont = False
    TabOrder = 4
    OnClick = Button3Click
  end
  object Button4: TButton
    Left = 376
    Top = 272
    Width = 81
    Height = 33
    Caption = 'Exit'
    Font.Charset = ANSI_CHARSET
    Font.Color = clWindowText
    Font.Height = -19
    Font.Name = 'Times New Roman'
    Font.Style = [fsItalic]
    ParentFont = False
    TabOrder = 5
    OnClick = Button4Click
  end
  object Timer1: TTimer
    OnTimer = Timer1Timer
    Left = 184
    Top = 128
  end
  object Timer2: TTimer
    OnTimer = Timer2Timer
    Left = 184
    Top = 192
  end
end

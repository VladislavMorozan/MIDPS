//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop

#include "MIDPS.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TForm2 *Form2;
int n;
//---------------------------------------------------------------------------
__fastcall TForm2::TForm2(TComponent* Owner)
        : TForm(Owner)
{
Form2->Caption = "MIDPS 1-A";
Label1->Caption = "Incrementare decrementare contor";

}
//---------------------------------------------------------------------------

void __fastcall TForm2::Button1Click(TObject *Sender)
{

     n++;
     Edit1->Text = IntToStr(n);
     Label2->Caption = "i se mareste cu 1";

}
//---------------------------------------------------------------------------
void __fastcall TForm2::Button2Click(TObject *Sender)
{

     n--;
     Edit1->Text = IntToStr(n);
     Label2->Caption = "i se scade cu 1";

}
//---------------------------------------------------------------------------
void __fastcall TForm2::Button3Click(TObject *Sender)
{
exit(1);        
}
//---------------------------------------------------------------------------


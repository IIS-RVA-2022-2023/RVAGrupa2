import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Artikl } from 'src/app/models/artikl';
import { ArtiklService } from 'src/app/services/artikl.service';

@Component({
  selector: 'app-artikl-dialog',
  templateUrl: './artikl-dialog.component.html',
  styleUrls: ['./artikl-dialog.component.css']
})
export class ArtiklDialogComponent {

  public flag!: number;
  constructor(public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<ArtiklDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Artikl,
    public artiklService: ArtiklService) { }

  public add(): void {
    this.artiklService.addArtikl(this.data).subscribe(() => {
      this.snackBar.open('Uspesno dodat artikl: ' + this.data.naziv, 'OK', {
        duration: 2500
      })
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
        this.snackBar.open('Doslo je do greske prilikom dodavanja novog artikla. ', 'Zatvori', {
          duration: 2500
        })
      };
  }


  public update(): void {
    this.artiklService.updateArtikl(this.data).subscribe(() => {
      this.snackBar.open('Uspesno izmenjen artikl: ' + this.data.naziv, 'OK', {
        duration: 2500
      })
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
        this.snackBar.open('Doslo je do greske prilikom izmene artikla. ', 'Zatvori', {
          duration: 2500
        })
      };

  }

  public delete(): void {
    this.artiklService.deleteArtikl(this.data.id).subscribe(() => {
      this.snackBar.open('Uspesno obrisan artikl: ' + this.data.naziv, 'OK', {
        duration: 2500
      })
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
        this.snackBar.open('Doslo je do greske prilikom brisanja artikla. ', 'Zatvori', {
          duration: 2500
        })
      };
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste od izmene. ', 'Zatvori', {
      duration: 1000
    })
  }
}

import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { Artikl } from 'src/app/models/artikl';
import { ArtiklService } from 'src/app/services/artikl.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { ArtiklDialogComponent } from '../dialogs/artikl-dialog/artikl-dialog.component';

@Component({
  selector: 'app-artikl',
  templateUrl: './artikl.component.html',
  styleUrls: ['./artikl.component.css']
})
export class ArtiklComponent {
  subscription!: Subscription;
  displayedColumns = ['id', 'naziv', 'proizvodjaca', 'actions'];
  dataSource!: MatTableDataSource<Artikl>;
  
  constructor(private artiklService: ArtiklService, private dialog: MatDialog) { }

  ngOnInit(): void { this.loadData(); }

  public loadData() {
    this.subscription = this.artiklService.getAllArtikli().subscribe(
      data => {
        //console.log(data);
        this.dataSource = new MatTableDataSource(data);
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
      }
    );
  }

  public openDialog(flag: number, artikl?: Artikl): void{
    const dialogRef = this.dialog.open(ArtiklDialogComponent, {data: artikl});
    dialogRef.componentInstance.flag = flag;
    dialogRef.afterClosed().subscribe(res => {
      if(res == 1)
        this.loadData();
    })
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }
}

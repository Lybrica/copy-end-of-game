import { Component, OnInit } from '@angular/core';
import {CategoryService} from "../../services/category.service";
import {Category} from "../../models/category";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})

export class CategoryComponent implements OnInit {

  categories: Array<Category> = [];
  displayedColumns: string[] = ["id", "name", "created", "updated"];
  dataSource = this.categories;


  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.categoryService.readCategoriesFromServer()
      .subscribe(categoriesFromServer => {
        this.categories = categoriesFromServer
        this.dataSource = this.categories;
        console.log(`data received from server, number of elements is: [${categoriesFromServer.length}]`)
      });
  }

}

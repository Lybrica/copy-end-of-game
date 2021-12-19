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

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.categoryService.readCategoriesFromServer()
      .subscribe(categoriesFromServer => this.categories = categoriesFromServer);
  }

}

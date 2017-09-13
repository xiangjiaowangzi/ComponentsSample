package com.example.android.persistence.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import com.example.android.persistence.db.dao.CommentDao;
import com.example.android.persistence.db.dao.CommentDao_Impl;
import com.example.android.persistence.db.dao.ProductDao;
import com.example.android.persistence.db.dao.ProductDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AppDatabase_Impl extends AppDatabase {
  private volatile ProductDao _productDao;

  private volatile CommentDao _commentDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate() {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `products` (`id` INTEGER, `name` TEXT, `description` TEXT, `price` INTEGER, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `comments` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `productId` INTEGER, `text` TEXT, `postedAt` INTEGER, FOREIGN KEY(`productId`) REFERENCES `products`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE  INDEX `index_comments_productId`\n"
                + "ON `comments` (`productId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"d023e2f96a9f3b54c574045ba47e285a\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `products`");
        _db.execSQL("DROP TABLE IF EXISTS `comments`");
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsProducts = new HashMap<String, TableInfo.Column>(4);
        _columnsProducts.put("id", new TableInfo.Column("id", "INTEGER", 1));
        _columnsProducts.put("name", new TableInfo.Column("name", "TEXT", 0));
        _columnsProducts.put("description", new TableInfo.Column("description", "TEXT", 0));
        _columnsProducts.put("price", new TableInfo.Column("price", "INTEGER", 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProducts = new HashSet<TableInfo.ForeignKey>(0);
        final TableInfo _infoProducts = new TableInfo("products", _columnsProducts, _foreignKeysProducts);
        final TableInfo _existingProducts = TableInfo.read(_db, "products");
        if (! _infoProducts.equals(_existingProducts)) {
          throw new IllegalStateException("Migration didn't properly handle products(com.example.android.persistence.db.entity.ProductEntity).\n"
                  + " Expected:\n" + _infoProducts + "\n"
                  + " Found:\n" + _existingProducts);
        }
        final HashMap<String, TableInfo.Column> _columnsComments = new HashMap<String, TableInfo.Column>(4);
        _columnsComments.put("id", new TableInfo.Column("id", "INTEGER", 1));
        _columnsComments.put("productId", new TableInfo.Column("productId", "INTEGER", 0));
        _columnsComments.put("text", new TableInfo.Column("text", "TEXT", 0));
        _columnsComments.put("postedAt", new TableInfo.Column("postedAt", "INTEGER", 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysComments = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysComments.add(new TableInfo.ForeignKey("products", "CASCADE", "NO ACTION",Arrays.asList("productId"), Arrays.asList("id")));
        final TableInfo _infoComments = new TableInfo("comments", _columnsComments, _foreignKeysComments);
        final TableInfo _existingComments = TableInfo.read(_db, "comments");
        if (! _infoComments.equals(_existingComments)) {
          throw new IllegalStateException("Migration didn't properly handle comments(com.example.android.persistence.db.entity.CommentEntity).\n"
                  + " Expected:\n" + _infoComments + "\n"
                  + " Found:\n" + _existingComments);
        }
      }
    }, "d023e2f96a9f3b54c574045ba47e285a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .version(1)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "products","comments");
  }

  @Override
  public ProductDao productDao() {
    if (_productDao != null) {
      return _productDao;
    } else {
      synchronized(this) {
        if(_productDao == null) {
          _productDao = new ProductDao_Impl(this);
        }
        return _productDao;
      }
    }
  }

  @Override
  public CommentDao commentDao() {
    if (_commentDao != null) {
      return _commentDao;
    } else {
      synchronized(this) {
        if(_commentDao == null) {
          _commentDao = new CommentDao_Impl(this);
        }
        return _commentDao;
      }
    }
  }
}

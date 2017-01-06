/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.druid.sql.dialect.sqlserver.parser;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.parser.SQLSelectParser;
import com.alibaba.druid.sql.parser.SQLStatementParser;

public class SQLServerStatementParser extends SQLStatementParser {
    
    public SQLServerStatementParser(final String sql) {
        super(new SQLServerExprParser(sql));
    }
    
    @Override
    protected SQLSelectParser createSQLSelectParser() {
        return new SQLServerSelectParser(exprParser);
    }
    
    public SQLServerExprParser getExprParser() {
        return (SQLServerExprParser) exprParser;
    }
    
    @Override
    public SQLStatement parseWith() {
        return parseSelect();
    }
}
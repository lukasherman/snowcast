/*
 * Copyright (c) 2015-2017, Christoph Engelbert (aka noctarius) and
 * contributors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.noctarius.snowcast.impl.operations;

import com.hazelcast.spi.BackupOperation;
import com.noctarius.snowcast.impl.NodeSequencerService;
import com.noctarius.snowcast.impl.SequencerDataSerializerHook;

public class BackupDestroySequencerDefinitionOperation
        extends AbstractSequencerOperation
        implements BackupOperation {

    public BackupDestroySequencerDefinitionOperation() {
    }

    public BackupDestroySequencerDefinitionOperation(String sequencerName) {
        super(sequencerName);
    }

    @Override
    public int getId() {
        return SequencerDataSerializerHook.TYPE_BACKUP_DESTROY_SEQUENCER_DEFINITION;
    }

    @Override
    public void run()
            throws Exception {

        NodeSequencerService sequencerService = getService();
        String sequencerName = getSequencerName();
        sequencerService.destroySequencer(sequencerName, true);
    }
}

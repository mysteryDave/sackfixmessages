package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class MDReqGrpComponent(noMDEntryTypesField:NoMDEntryTypesField,
                             mDEntryTypesGroups: List[MDEntryTypesGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMDEntryTypesField.value != mDEntryTypesGroups.size)
    throw SfRepeatingGroupCountException(NoMDEntryTypesField.TagId,noMDEntryTypesField.value, mDEntryTypesGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noMDEntryTypesField)
    b
  }

}
     
object MDReqGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoMDEntryTypesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MDEntryTypesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MDEntryTypesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MDEntryTypesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMDEntryTypesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = MDEntryTypesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[MDReqGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(MDReqGrpComponent(NoMDEntryTypesField.decode(myFields.get(NoMDEntryTypesField.TagId)).get,
        if (nextTagPosLookup.contains(NoMDEntryTypesField.TagId)) MDEntryTypesGroup.decode(flds, nextTagPosLookup(NoMDEntryTypesField.TagId)).get else List.empty))
    } else None
  }

    
}
     
package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class PositionAmountDataComponent(noPosAmtField:NoPosAmtField,
                                       posAmtGroups: List[PosAmtGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noPosAmtField.value != posAmtGroups.size)
    throw SfRepeatingGroupCountException(NoPosAmtField.TagId,noPosAmtField.value, posAmtGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noPosAmtField)
    b
  }

}
     
object PositionAmountDataComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoPosAmtField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PosAmtGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PosAmtGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PosAmtGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoPosAmtField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = PosAmtGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[PositionAmountDataComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(PositionAmountDataComponent(NoPosAmtField.decode(myFields.get(NoPosAmtField.TagId)).get,
        if (nextTagPosLookup.contains(NoPosAmtField.TagId)) PosAmtGroup.decode(flds, nextTagPosLookup(NoPosAmtField.TagId)).get else List.empty))
    } else None
  }

    
}
     
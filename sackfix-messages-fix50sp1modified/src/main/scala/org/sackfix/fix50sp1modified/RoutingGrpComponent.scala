package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class RoutingGrpComponent(noRoutingIDsField:Option[NoRoutingIDsField]=None,
                               routingIDsGroups: Option[List[RoutingIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRoutingIDsField.map(_.value).getOrElse(0) != routingIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRoutingIDsField.TagId,noRoutingIDsField.map(_.value).getOrElse(0), routingIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noRoutingIDsField.foreach(fmt(b,_))
    routingIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object RoutingGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RoutingIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoRoutingIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RoutingIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RoutingIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRoutingIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = RoutingIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[RoutingGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(RoutingGrpComponent(myFields.get(NoRoutingIDsField.TagId).flatMap(f=>NoRoutingIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoRoutingIDsField.TagId)) RoutingIDsGroup.decode(flds, nextTagPosLookup(NoRoutingIDsField.TagId)) else None))
    } else None
  }

    
}
     